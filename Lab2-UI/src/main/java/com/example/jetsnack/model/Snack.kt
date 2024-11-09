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
        imageRes = "https://loremflickr.com/cache/resized/65535_52008087018_6dd69462da_n_320_240_nofilter.jpg",
        price = "299"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Donut",
        tagline = "Vegetarian",
        taste = "Gluten-free",
        imageRes = "https://loremflickr.com/cache/resized/65535_53826762682_e03dec035f_320_240_nofilter.jpg",
        price = "299"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Eclair",
        tagline = "Vegetarian",
        taste = "Sweet",
        imageRes = "https://loremflickr.com/cache/resized/65535_51930438915_f6f481211d_320_240_nofilter.jpg",
        price = "299"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Froyo",
        tagline = "Vegetarian",
        taste = "Sweet",
        imageRes = "https://loremflickr.com/cache/resized/7677_17382412371_a19fe743bf_320_240_nofilter.jpg",
        price = "299"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Gingerbread",
        tagline = "Vegetarian",
        taste = "Sweet",
        imageRes = "https://loremflickr.com/cache/resized/65535_53366812664_e25fa19807_320_240_nofilter.jpg",
        price = "499"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Honeycomb",
        tagline = "Vegetarian",
        taste = "Sweet",
        imageRes = "https://loremflickr.com/cache/resized/65535_54096474773_13cda30ff4_n_320_240_nofilter.jpg",
        price = "299"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Ice Cream Sandwich",
        tagline = "Vegetarian",
        taste = "Sweet",
        imageRes = "https://loremflickr.com/cache/resized/65535_53562688253_f5fd1639f2_320_240_nofilter.jpg",
        price = "1299"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Jellybean",
        tagline = "Vegetarian",
        taste = "Sweet",
        imageRes = "https://loremflickr.com/cache/resized/5661_21597823433_848fe1008e_320_240_nofilter.jpg",
        price = "299"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "KitKat",
        tagline = "Vegetarian",
        taste = "Sweet",
        imageRes = "https://loremflickr.com/cache/resized/7291_15928194223_25c0510a24_320_240_nofilter.jpg",
        price = "549"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Lollipop",
        tagline = "Vegetarian",
        taste = "Sweet",
        imageRes = "https://loremflickr.com/cache/resized/7291_15928194223_25c0510a24_320_240_nofilter.jpg",
        price = "299"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Marshmallow",
        tagline = "Vegetarian",
        taste = "Sweet",
        imageRes = "https://loremflickr.com/cache/resized/7291_15928194223_25c0510a24_320_240_nofilter.jpg",
        price = "299"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Nougat",
        tagline = "Vegetarian",
        taste = "Sweet",
        imageRes = "https://loremflickr.com/cache/resized/7291_15928194223_25c0510a24_320_240_nofilter.jpg",
        price = "299"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Oreo",
        tagline = "Vegetarian",
        taste = "Sweet",
        imageRes = "https://loremflickr.com/cache/resized/7291_15928194223_25c0510a24_320_240_nofilter.jpg",
        price = "299"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Pie",
        tagline = "Vegetarian",
        taste = "Sweet",
        imageRes = "https://loremflickr.com/cache/resized/7291_15928194223_25c0510a24_320_240_nofilter.jpg",
        price = "299"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Chips",
        tagline = "Vegan",
        taste = "Savory",
        imageRes = "https://loremflickr.com/cache/resized/7291_15928194223_25c0510a24_320_240_nofilter.jpg",
        price = "299"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Pretzels",
        tagline = "Vegan",
        taste = "Savory",
        imageRes = "https://loremflickr.com/cache/resized/7291_15928194223_25c0510a24_320_240_nofilter.jpg",
        price = "299"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Smoothies",
        tagline = "Vegan",
        taste = "Sweet",
        imageRes = "https://loremflickr.com/cache/resized/7291_15928194223_25c0510a24_320_240_nofilter.jpg",
        price = "299"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Popcorn",
        tagline = "Gluten Free",
        taste = "Savory",
        imageRes = "https://loremflickr.com/cache/resized/7291_15928194223_25c0510a24_320_240_nofilter.jpg",
        price = "299"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Almonds",
        tagline = "Whole30",
        taste = "Dairy-free",
        imageRes = "https://loremflickr.com/cache/resized/7291_15928194223_25c0510a24_320_240_nofilter.jpg",
        price = "299"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Cheese",
        tagline = "Gluten Free",
        taste = "Savory",
        imageRes = "https://loremflickr.com/cache/resized/7291_15928194223_25c0510a24_320_240_nofilter.jpg",
        price = "299"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Apples",
        tagline = "Paleo",
        taste = "Organic",
        imageRes = "https://loremflickr.com/cache/resized/7291_15928194223_25c0510a24_320_240_nofilter.jpg",
        price = "299"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Apple sauce",
        tagline = "Gluten Free",
        taste = "Sweet",
        imageRes = "https://loremflickr.com/cache/resized/7291_15928194223_25c0510a24_320_240_nofilter.jpg",
        price = "299"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Apple chips",
        tagline = "Gluten Free",
        taste = "Sweet",
        imageRes = "https://loremflickr.com/cache/resized/7291_15928194223_25c0510a24_320_240_nofilter.jpg",
        price = "299"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Apple juice",
        tagline = "Gluten Free",
        taste = "Sweet",
        imageRes = "https://loremflickr.com/cache/resized/7291_15928194223_25c0510a24_320_240_nofilter.jpg",
        price = "299"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Apple pie",
        tagline = "Vegetarian",
        taste = "Sweet",
        imageRes = "https://loremflickr.com/cache/resized/7291_15928194223_25c0510a24_320_240_nofilter.jpg",
        price = "299"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Grapes",
        tagline = "Organic",
        taste = "Organic",
        imageRes = "https://loremflickr.com/cache/resized/7291_15928194223_25c0510a24_320_240_nofilter.jpg",
        price = "299"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Kiwi",
        tagline = "Organic",
        taste = "Organic",
        imageRes = "https://loremflickr.com/cache/resized/7291_15928194223_25c0510a24_320_240_nofilter.jpg",
        price = "299"
    ),
    Snack(
        id = "${Random.nextLong()}",
        name = "Mango",
        tagline = "Organic",
        taste = "Organic",
        imageRes = "https://loremflickr.com/cache/resized/7291_15928194223_25c0510a24_320_240_nofilter.jpg",
        price = "299"
    )
)