package com.example.movie.domain.usecase

import com.example.movie.domain.repository.MovieRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

abstract class DefaultMovieUseCase: KoinComponent {
    internal val repository: MovieRepository by inject()
}