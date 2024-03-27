package com.example.movie.domain.repository

import com.example.movie.domain.model.Movie

internal interface MovieRepository {
    suspend fun getMovies(page: Int): Set<Movie>

    suspend fun getMovie(movieId: Int): Movie
}