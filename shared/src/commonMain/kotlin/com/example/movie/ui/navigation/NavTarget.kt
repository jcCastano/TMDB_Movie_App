package com.example.movie.ui.navigation

import com.bumble.appyx.utils.multiplatform.Parcelable
import com.bumble.appyx.utils.multiplatform.Parcelize

sealed class NavTarget: Parcelable {
    @Parcelize
    object Movie: NavTarget()

    @Parcelize
    object Detail: NavTarget()
}