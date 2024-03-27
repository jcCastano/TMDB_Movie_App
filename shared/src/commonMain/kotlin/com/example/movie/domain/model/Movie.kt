package com.example.movie.domain.model

import androidx.compose.runtime.Immutable
import com.bumble.appyx.utils.multiplatform.Parcelable
import com.bumble.appyx.utils.multiplatform.Parcelize

@Immutable
@Parcelize
data class Movie(
    val id: Int,
    val title: String,
    val description: String,
    val imageUrl: String,
    val releaseDate: String,
): Parcelable
