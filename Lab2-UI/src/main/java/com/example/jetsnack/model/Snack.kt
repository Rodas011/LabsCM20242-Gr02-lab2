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

package com.example.jetsnack.model

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Immutable
import com.example.jetsnack.R
import kotlinx.serialization.Serializable
import kotlin.random.Random

@Serializable
data class Snack(
    val id: String,
    val name: String,
    val imageRes: String,
    val price: String,
    val tagline: String = "",
    val tags: ArrayList<String> = arrayListOf()
)

@Immutable
data class Snack1(
    val id: Long,
    val name: String,
    @DrawableRes
    val imageRes: Int,
    val price: Long,
    val tagline: String = "",
    val tags: Set<String> = emptySet()
)

/**
 * Static data
 */

val snacks = listOf(
    Snack1(
        id = 1L,
        name = "Cupcake",
        tagline = "Vegetarian",
        imageRes = R.drawable.cupcake,
        price = 299
    ),
    Snack1(
        id = Random.nextLong(),
        name = "Donut",
        tagline = "Vegetarian",
        imageRes = R.drawable.donut,
        price = 299
    ),
    Snack1(
        id = Random.nextLong(),
        name = "Eclair",
        tagline = "Vegetarian",
        imageRes = R.drawable.eclair,
        price = 299
    ),
    Snack1(
        id = Random.nextLong(),
        name = "Froyo",
        tagline = "Vegetarian",
        imageRes = R.drawable.froyo,
        price = 299
    ),
    Snack1(
        id = Random.nextLong(),
        name = "Gingerbread",
        tagline = "Vegetarian",
        imageRes = R.drawable.gingerbread,
        price = 499
    ),
    Snack1(
        id = Random.nextLong(),
        name = "Honeycomb",
        tagline = "Vegetarian",
        imageRes = R.drawable.honeycomb,
        price = 299
    ),
    Snack1(
        id = Random.nextLong(),
        name = "Ice Cream Sandwich",
        tagline = "Vegetarian",
        imageRes = R.drawable.ice_cream_sandwich,
        price = 1299
    ),
    Snack1(
        id = Random.nextLong(),
        name = "Jellybean",
        tagline = "Vegetarian",
        imageRes = R.drawable.jelly_bean,
        price = 299
    ),
    Snack1(
        id = Random.nextLong(),
        name = "KitKat",
        tagline = "Vegetarian",
        imageRes = R.drawable.kitkat,
        price = 549
    ),
    Snack1(
        id = Random.nextLong(),
        name = "Lollipop",
        tagline = "Vegetarian",
        imageRes = R.drawable.lollipop,
        price = 299
    ),
    Snack1(
        id = Random.nextLong(),
        name = "Marshmallow",
        tagline = "Vegetarian",
        imageRes = R.drawable.marshmallow,
        price = 299
    ),
    Snack1(
        id = Random.nextLong(),
        name = "Nougat",
        tagline = "Vegetarian",
        imageRes = R.drawable.nougat,
        price = 299
    ),
    Snack1(
        id = Random.nextLong(),
        name = "Oreo",
        tagline = "Vegetarian",
        imageRes = R.drawable.oreo,
        price = 299
    ),
    Snack1(
        id = Random.nextLong(),
        name = "Pie",
        tagline = "Vegetarian",
        imageRes = R.drawable.pie,
        price = 299
    ),
    Snack1(
        id = Random.nextLong(),
        name = "Chips",
        tagline = "Vegan",
        imageRes = R.drawable.chips,
        price = 299
    ),
    Snack1(
        id = Random.nextLong(),
        name = "Pretzels",
        tagline = "Vegan",
        imageRes = R.drawable.pretzels,
        price = 299
    ),
    Snack1(
        id = Random.nextLong(),
        name = "Smoothies",
        tagline = "Vegan",
        imageRes = R.drawable.smoothies,
        price = 299
    ),
    Snack1(
        id = Random.nextLong(),
        name = "Popcorn",
        tagline = "Gluten Free",
        imageRes = R.drawable.popcorn,
        price = 299
    ),
    Snack1(
        id = Random.nextLong(),
        name = "Almonds",
        tagline = "Whole30",
        imageRes = R.drawable.almonds,
        price = 299
    ),
    Snack1(
        id = Random.nextLong(),
        name = "Cheese",
        tagline = "Gluten Free",
        imageRes = R.drawable.cheese,
        price = 299
    ),
    Snack1(
        id = Random.nextLong(),
        name = "Apples",
        tagline = "Paleo",
        imageRes = R.drawable.apples,
        price = 299
    ),
    Snack1(
        id = Random.nextLong(),
        name = "Apple sauce",
        tagline = "Gluten Free",
        imageRes = R.drawable.apple_sauce,
        price = 299
    ),
    Snack1(
        id = Random.nextLong(),
        name = "Apple chips",
        tagline = "Gluten Free",
        imageRes = R.drawable.apple_chips,
        price = 299
    ),
    Snack1(
        id = Random.nextLong(),
        name = "Apple juice",
        tagline = "Gluten Free",
        imageRes = R.drawable.apple_juice,
        price = 299
    ),
    Snack1(
        id = Random.nextLong(),
        name = "Apple pie",
        tagline = "Vegetarian",
        imageRes = R.drawable.apple_pie,
        price = 299
    ),
    Snack1(
        id = Random.nextLong(),
        name = "Grapes",
        tagline = "Organic",
        imageRes = R.drawable.grapes,
        price = 299
    ),
    Snack1(
        id = Random.nextLong(),
        name = "Kiwi",
        tagline = "Organic",
        imageRes = R.drawable.kiwi,
        price = 299
    ),
    Snack1(
        id = Random.nextLong(),
        name = "Mango",
        tagline = "Organic",
        imageRes = R.drawable.mango,
        price = 299
    )
)