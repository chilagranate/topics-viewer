package com.example.coursesviewer.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val name: Int,
    val cant: Int,
    @DrawableRes val image: Int
)