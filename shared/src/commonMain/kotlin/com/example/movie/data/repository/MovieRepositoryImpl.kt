package com.example.movie.data.repository

import com.example.movie.data.remote.RemoteDataSource
import com.example.movie.data.util.toMovie
import com.example.movie.domain.model.Movie
import com.example.movie.domain.repository.MovieRepository

internal class MovieRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
): MovieRepository {

    override suspend fun getMovies(page: Int): Set<Movie> {
        return remoteDataSource.getMovies(page = page).results.map {
            it.toMovie()
        }.toSet()
    }

    override suspend fun getMovie(movieId: Int): Movie {
        return remoteDataSource.getMovie(movieId = movieId).toMovie()
    }

}