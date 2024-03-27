package com.example.movie.di

import com.example.movie.data.remote.MovieService
import com.example.movie.data.remote.RemoteDataSource
import com.example.movie.data.repository.MovieRepositoryImpl
import com.example.movie.domain.repository.MovieRepository
import com.example.movie.domain.usecase.GetMovieUseCase
import com.example.movie.domain.usecase.GetMoviesUseCase
import com.example.movie.ui.detail.DetailViewModel
import com.example.movie.ui.home.HomeViewModel
import com.example.movie.util.provideDispatcher
import org.koin.dsl.module

val sharedModule = module {
    factory { GetMoviesUseCase() }
    factory { GetMovieUseCase() }
    factory { MovieService() }
    factory { provideDispatcher() }
    factory { RemoteDataSource(get(), get()) }
    single<MovieRepository> { MovieRepositoryImpl(get()) }
    single<HomeViewModel> { HomeViewModel(get()) }
    factory { (movieId: Int) -> DetailViewModel(get(), movieId) }
}