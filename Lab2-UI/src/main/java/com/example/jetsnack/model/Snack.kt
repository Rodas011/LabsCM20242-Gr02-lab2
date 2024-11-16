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
    val taste: String = "",
    val tags: ArrayList<String> = arrayListOf()
)

/**
 * Static data
 */

val snacks = listOf(
  Snack(
        id = "1",
        name = "Cupcake",
        tagline = "Vegetarian",
        taste = "Sweet",
        imageRes = "https://loremflickr.com/320/240/dessert?random=11",
        price = "299"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Donut",
        tagline = "Vegetarian",
        taste = "Gluten-free",
        imageRes = "https://loremflickr.com/320/240/dessert?random=12",
        price = "299"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Eclair",
        tagline = "Vegetarian",
        taste = "Sweet",
        imageRes = "https://loremflickr.com/320/240/dessert?random=13",
        price = "299"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Froyo",
        tagline = "Vegetarian",
        taste = "Sweet",
        imageRes = "https://loremflickr.com/320/240/dessert?random=14",
        price = "299"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Gingerbread",
        tagline = "Vegetarian",
        taste = "Sweet",
        imageRes = "https://loremflickr.com/320/240/dessert?random=15",
        price = "499"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Honeycomb",
        tagline = "Vegetarian",
        taste = "Sweet",
        imageRes = "https://loremflickr.com/320/240/dessert?random=16",
        price = "299"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Ice Cream Sandwich",
        tagline = "Vegetarian",
        taste = "Sweet",
        imageRes = "https://loremflickr.com/320/240/dessert?random=17",
        price = "1299"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Jellybean",
        tagline = "Vegetarian",
        taste = "Sweet",
        imageRes = "https://loremflickr.com/320/240/dessert?random=18",
        price = "299"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "KitKat",
        tagline = "Vegetarian",
        taste = "Sweet",
        imageRes = "https://loremflickr.com/320/240/dessert?random=19",
        price = "549"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Lollipop",
        tagline = "Vegetarian",
        taste = "Sweet",
        imageRes = "https://loremflickr.com/320/240/dessert?random=20",
        price = "299"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Marshmallow",
        tagline = "Vegetarian",
        taste = "Sweet",
        imageRes = "https://loremflickr.com/320/240/dessert?random=21",
        price = "299"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Nougat",
        tagline = "Vegetarian",
        taste = "Sweet",
        imageRes = "https://loremflickr.com/320/240/dessert?random=22",
        price = "299"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Oreo",
        tagline = "Vegetarian",
        taste = "Sweet",
        imageRes = "https://loremflickr.com/320/240/dessert?random=23",
        price = "299"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Pie",
        tagline = "Vegetarian",
        taste = "Sweet",
        imageRes = "https://loremflickr.com/320/240/dessert?random=24",
        price = "299"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Chips",
        tagline = "Vegan",
        taste = "Savory",
        imageRes = "https://loremflickr.com/320/240/dessert?random=25",
        price = "299"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Pretzels",
        tagline = "Vegan",
        taste = "Savory",
        imageRes = "https://loremflickr.com/320/240/dessert?random=26",
        price = "299"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Smoothies",
        tagline = "Vegan",
        taste = "Sweet",
        imageRes = "https://loremflickr.com/320/240/dessert?random=27",
        price = "299"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Popcorn",
        tagline = "Gluten Free",
        taste = "Savory",
        imageRes = "https://loremflickr.com/320/240/dessert?random=28",
        price = "299"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Almonds",
        tagline = "Whole30",
        taste = "Dairy-free",
        imageRes = "https://loremflickr.com/320/240/dessert?random=29",
        price = "299"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Cheese",
        tagline = "Gluten Free",
        taste = "Savory",
        imageRes = "https://loremflickr.com/320/240/dessert?random=30",
        price = "299"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Apples",
        tagline = "Paleo",
        taste = "Organic",
        imageRes = "https://loremflickr.com/320/240/dessert?random=31",
        price = "299"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Apple sauce",
        tagline = "Gluten Free",
        taste = "Sweet",
        imageRes = "https://loremflickr.com/320/240/dessert?random=32",
        price = "299"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Apple chips",
        tagline = "Gluten Free",
        taste = "Sweet",
        imageRes = "https://loremflickr.com/320/240/dessert?random=33",
        price = "299"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Apple juice",
        tagline = "Gluten Free",
        taste = "Sweet",
        imageRes = "https://loremflickr.com/320/240/dessert?random=34",
        price = "299"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Apple pie",
        tagline = "Vegetarian",
        taste = "Sweet",
        imageRes = "https://loremflickr.com/320/240/dessert?random=35",
        price = "299"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Grapes",
        tagline = "Organic",
        taste = "Organic",
        imageRes = "https://loremflickr.com/320/240/dessert?random=36",
        price = "299"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Kiwi",
        tagline = "Organic",
        taste = "Organic",
        imageRes = "https://loremflickr.com/320/240/dessert?random=37",
        price = "299"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Mango",
        tagline = "Organic",
        taste = "Organic",
        imageRes = "https://loremflickr.com/320/240/dessert?random=38",
        price = "299"
    )
)