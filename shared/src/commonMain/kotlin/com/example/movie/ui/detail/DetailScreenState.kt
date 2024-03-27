package com.example.movie.ui.detail

import com.example.movie.domain.model.Movie

data class DetailScreenState(
    var loading: Boolean = false,
    var movie: Movie? = null,
    var errorMessage: String? = null
)
