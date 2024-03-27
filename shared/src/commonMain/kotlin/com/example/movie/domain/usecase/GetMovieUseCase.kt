package com.example.movie.domain.usecase

import com.example.movie.domain.model.Movie

class GetMovieUseCase: DefaultMovieUseCase() {
    @Throws(Exception::class)
    suspend operator fun invoke(movieId: Int): Movie {
        return repository.getMovie(movieId = movieId)
    }
}