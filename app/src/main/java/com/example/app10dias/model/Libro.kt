package com.example.app10dias.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Libro(
    @StringRes val titulo: Int,
    @StringRes val autor: Int,
    @StringRes val descripcion: Int,
    @DrawableRes val imageRes: Int
)
