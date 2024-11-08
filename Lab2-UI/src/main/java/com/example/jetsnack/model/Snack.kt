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

/**
 * Static data
 */

val snacks = listOf(
    Snack(
        id = "1",
        name = "Cupcake",
        tagline = "A tag line",
        imageRes = "https://loremflickr.com/640/480/dessert",
        price = "299"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Donut",
        tagline = "A tag line",
        imageRes = "https://loremflickr.com/640/480/dessert",
        price = "299"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Eclair",
        tagline = "A tag line",
        imageRes = "https://loremflickr.com/640/480/dessert",
        price = "299"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Froyo",
        tagline = "A tag line",
        imageRes = "https://loremflickr.com/640/480/dessert",
        price = "299"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Gingerbread",
        tagline = "A tag line",
        imageRes = "https://loremflickr.com/640/480/dessert",
        price = "499"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Honeycomb",
        tagline = "A tag line",
        imageRes = "https://loremflickr.com/640/480/dessert",
        price = "299"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Ice Cream Sandwich",
        tagline = "A tag line",
        imageRes = "https://loremflickr.com/640/480/dessert",
        price = "1299"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Jellybean",
        tagline = "A tag line",
        imageRes = "https://loremflickr.com/640/480/dessert",
        price = "299"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "KitKat",
        tagline = "A tag line",
        imageRes = "https://loremflickr.com/640/480/dessert",
        price = "549"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Lollipop",
        tagline = "A tag line",
        imageRes = "https://loremflickr.com/640/480/dessert",
        price = "299"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Marshmallow",
        tagline = "A tag line",
        imageRes = "https://loremflickr.com/640/480/dessert",
        price = "299"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Nougat",
        tagline = "A tag line",
        imageRes = "https://loremflickr.com/640/480/dessert",
        price = "299"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Oreo",
        tagline = "A tag line",
        imageRes = "https://loremflickr.com/640/480/dessert",
        price = "299"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Pie",
        tagline = "A tag line",
        imageRes = "https://loremflickr.com/640/480/dessert",
        price = "299"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Chips",
        imageRes = "https://loremflickr.com/640/480/dessert",
        price = "299"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Pretzels",
        imageRes = "https://loremflickr.com/640/480/dessert",
        price = "299"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Smoothies",
        imageRes = "https://loremflickr.com/640/480/dessert",
        price = "299"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Popcorn",
        imageRes = "https://loremflickr.com/640/480/dessert",
        price = "299"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Almonds",
        imageRes = "https://loremflickr.com/640/480/dessert",
        price = "299"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Cheese",
        imageRes = "https://loremflickr.com/640/480/dessert",
        price = "299"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Apples",
        tagline = "A tag line",
        imageRes = "https://loremflickr.com/640/480/dessert",
        price = "299"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Apple sauce",
        tagline = "A tag line",
        imageRes = "https://loremflickr.com/640/480/dessert",
        price = "299"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Apple chips",
        tagline = "A tag line",
        imageRes = "https://loremflickr.com/640/480/dessert",
        price = "299"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Apple juice",
        tagline = "A tag line",
        imageRes = "https://loremflickr.com/640/480/dessert",
        price = "299"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Apple pie",
        tagline = "A tag line",
        imageRes = "https://loremflickr.com/640/480/dessert",
        price = "299"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Grapes",
        tagline = "A tag line",
        imageRes = "https://loremflickr.com/640/480/dessert",
        price = "299"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Kiwi",
        tagline = "A tag line",
        imageRes = "https://loremflickr.com/640/480/dessert",
        price = "299"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Mango",
        tagline = "A tag line",
        imageRes = "https://loremflickr.com/640/480/dessert",
        price = "299"
    )
)
