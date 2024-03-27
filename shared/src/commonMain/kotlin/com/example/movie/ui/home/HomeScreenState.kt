package com.example.movie.ui.home

import androidx.compose.foundation.lazy.grid.LazyGridState
import com.example.movie.domain.model.Movie

data class HomeScreenState(
    var loading: Boolean = false,
    var refreshing: Boolean = false,
    var movies: Set<Movie> = emptySet(),
    var errorMessage: String? = null,
    var loadFinished: Boolean = false,
    var scrollState: LazyGridState? = null
)
