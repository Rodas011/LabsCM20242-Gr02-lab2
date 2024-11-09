/*
 * Copyright 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

@file:OptIn(ExperimentalSharedTransitionApi::class)

package com.example.jetsnack.ui.components

import android.content.res.Configuration
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.FilterList
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkInfo
import androidx.work.WorkManager
import androidx.work.workDataOf
import com.example.jetsnack.R
import com.example.jetsnack.model.Filter
import com.example.jetsnack.model.Snack
import com.example.jetsnack.model.SnackRepo
import com.example.jetsnack.model.snacks
import com.example.jetsnack.ui.FilterSharedElementKey
import com.example.jetsnack.ui.home.FeedFilterWorker
import com.example.jetsnack.ui.home.SnackFilterWorker
import com.example.jetsnack.ui.navigation.rememberJetsnackNavController
import com.example.jetsnack.ui.theme.JetsnackTheme
import kotlin.random.Random

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun FilterBar(
    filters: List<Filter>,
    onShowFilters: () -> Unit,
    filterScreenVisible: Boolean,
    sharedTransitionScope: SharedTransitionScope,
    onSnackClick: (Long, String) -> Unit
) {

    var selectedFilter by remember { mutableStateOf<String?>(null) }

    with(sharedTransitionScope) {
        LazyRow(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(start = 12.dp, end = 8.dp),
            modifier = Modifier.heightIn(min = 56.dp)
        ) {
            item {
                AnimatedVisibility(visible = !filterScreenVisible) {
                    IconButton(
                        onClick = onShowFilters,
                        modifier = Modifier
                            .sharedBounds(
                                rememberSharedContentState(FilterSharedElementKey),
                                animatedVisibilityScope = this@AnimatedVisibility,
                                resizeMode = SharedTransitionScope.ResizeMode.RemeasureToBounds
                            )
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.FilterList,
                            tint = JetsnackTheme.colors.brand,
                            contentDescription = stringResource(R.string.label_filters),
                            modifier = Modifier.diagonalGradientBorder(
                                colors = JetsnackTheme.colors.interactiveSecondary,
                                shape = CircleShape
                            )
                        )
                    }
                }
            }
            items(filters) { filter ->
                FilterChip(filter = filter, shape = MaterialTheme.shapes.small, onClick = { filterName -> selectedFilter = filterName})
            }


        }
    }
    selectedFilter?.let {
        FilterSnacksTaste(tagline = it)
    }
}

@Composable
fun FilterChip(
    filter: Filter,
    modifier: Modifier = Modifier,
    shape: Shape = MaterialTheme.shapes.small,
    onClick: (String) -> Unit
) {
    val (selected, setSelected) = filter.enabled
    val backgroundColor by animateColorAsState(
        if (selected) JetsnackTheme.colors.brandSecondary else JetsnackTheme.colors.uiBackground,
        label = "background color"
    )
    val border = Modifier.fadeInDiagonalGradientBorder(
        showBorder = !selected,
        colors = JetsnackTheme.colors.interactiveSecondary,
        shape = shape
    )
    val textColor by animateColorAsState(
        if (selected) Color.Black else JetsnackTheme.colors.textSecondary,
        label = "text color"
    )

    JetsnackSurface(
        modifier = modifier,
        color = backgroundColor,
        contentColor = textColor,
        shape = shape,
        elevation = 2.dp
    ) {
        val interactionSource = remember { MutableInteractionSource() }

        val pressed by interactionSource.collectIsPressedAsState()
        val backgroundPressed =
            if (pressed) {
                Modifier.offsetGradientBackground(
                    JetsnackTheme.colors.interactiveSecondary,
                    200f,
                    0f
                )
            } else {
                Modifier.background(Color.Transparent)
            }

        Box(
            modifier = Modifier
                .toggleable(
                    value = selected,
                    onValueChange = {
                        setSelected(it)
                        onClick(filter.name)
                    },
                    interactionSource = interactionSource,
                    indication = null
                )
                .then(backgroundPressed)
                .then(border),
        ) {
            Text(
                text = filter.name,
                style = MaterialTheme.typography.bodySmall,
                maxLines = 1,
                modifier = Modifier.padding(
                    horizontal = 20.dp,
                    vertical = 6.dp
                )
            )
        }
    }
}

@Composable
fun FilterSnacksFeed(tagline: String){
    val context = LocalContext.current
    val workManager = WorkManager.getInstance(context)
    val jetsnackNavController = rememberJetsnackNavController()


    val filterRequest = remember {
        OneTimeWorkRequestBuilder<FeedFilterWorker>().setInputData(workDataOf("tagline" to tagline)).build()
    }

    LaunchedEffect(Unit) {
        workManager.enqueue(filterRequest)
    }

    val workInfo = workManager.getWorkInfoByIdLiveData(filterRequest.id).observeAsState()

    when(workInfo.value?.state) {
        WorkInfo.State.RUNNING -> Text("Filtrando productos")
        WorkInfo.State.SUCCEEDED -> {
            val filteredSnacks = workInfo.value?.outputData?.getStringArray("KEY_SNACK")

            val selectedSnacks = filteredSnacks?.filterNotNull()?.toSet()

            val finalSnacks = snacks.filter { it.name in selectedSnacks.orEmpty() }

            val snackCollection = com.example.jetsnack.model.SnackCollection(
                id = Random.nextLong(),
                name = tagline,
                snacks = finalSnacks
            )

            SnackCollection(
                snackCollection = snackCollection,
                onSnackClick = { id, origin -> jetsnackNavController::navigateToSnackDetail }
            )




        }
        WorkInfo.State.FAILED -> Text("Ha fallado el filtrado")
        else -> Text("Esperando a que empiece el filtrado")
    }
}

@Composable
fun FilterSnacksTaste(tagline: String){
    val context = LocalContext.current
    val workManager = WorkManager.getInstance(context)
    val jetsnackNavController = rememberJetsnackNavController()

    var filteredSnacks by remember { mutableStateOf<List<Snack>>(emptyList()) }
    var isLoading by remember { mutableStateOf(true) }

    val filterRequest = remember {
        OneTimeWorkRequestBuilder<SnackFilterWorker>().setInputData(workDataOf("tagline" to tagline)).build()
    }

    LaunchedEffect(tagline) {
        isLoading = true
        workManager.enqueue(filterRequest)
    }

    val workInfo = workManager.getWorkInfoByIdLiveData(filterRequest.id).observeAsState()

    when(workInfo.value?.state) {
        WorkInfo.State.RUNNING -> {
            isLoading = true
            Text("Filtrando productos")
        }
        WorkInfo.State.SUCCEEDED -> {
            isLoading = false
            // Extract the filtered snack names from the worker output
            val snackNames = workInfo.value?.outputData?.getStringArray("KEY_SNACK")
            val filteredSnackNames = snackNames?.filterNotNull()?.toSet() ?: emptySet()

            // Filter the snacks based on the snack names
            val finalSnacks = snacks.filter { it.name in filteredSnackNames }

            // Update the filtered snacks state
            filteredSnacks = finalSnacks

            val snackCollection = com.example.jetsnack.model.SnackCollection(
                id = Random.nextLong(),
                name = tagline,
                snacks = finalSnacks
            )

            SnackCollection(
                snackCollection = snackCollection,
                onSnackClick = { id, origin -> jetsnackNavController::navigateToSnackDetail }
            )

        }
        WorkInfo.State.FAILED -> {
            isLoading = false
            Text("Ha fallado el filtrado")
        }
        else -> {
            isLoading = false
            Text("Esperando a que empiece el filtrado")
        }
    }

    if (isLoading) {
        CircularProgressIndicator()
    }
}




@Preview("default")
@Preview("dark theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview("large font", fontScale = 2f)
@Composable
private fun FilterDisabledPreview() {
    JetsnackTheme {
        var selectedFilter by remember { mutableStateOf<String?>(null) }

        FilterChip(Filter(name = "Demo", enabled = false), Modifier.padding(4.dp), onClick = { filterName -> selectedFilter = filterName})
    }
}

@Preview("default")
@Preview("dark theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview("large font", fontScale = 2f)
@Composable
private fun FilterEnabledPreview() {
    JetsnackTheme {
        var selectedFilter by remember { mutableStateOf<String?>(null) }

        FilterChip(Filter(name = "Demo", enabled = true), onClick = { filterName -> selectedFilter = filterName} )
    }
}


