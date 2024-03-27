package com.example.movie.ui.navigation

import com.bumble.appyx.utils.multiplatform.Parcelable
import com.bumble.appyx.utils.multiplatform.Parcelize
import com.example.movie.domain.model.Movie

sealed class NavTarget: Parcelable {
    @Parcelize
    object Home: NavTarget()

    @Parcelize
    data class Detail(val movie: Movie) : NavTarget()
}