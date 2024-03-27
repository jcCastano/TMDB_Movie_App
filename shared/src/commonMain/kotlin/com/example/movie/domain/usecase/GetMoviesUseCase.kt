package com.example.movie.domain.usecase

import com.example.movie.domain.model.Movie

class GetMoviesUseCase: DefaultMovieUseCase() {
    @Throws(Exception::class)
    suspend operator fun invoke(page: Int): Set<Movie> {
        return repository.getMovies(page = page)
    }
}