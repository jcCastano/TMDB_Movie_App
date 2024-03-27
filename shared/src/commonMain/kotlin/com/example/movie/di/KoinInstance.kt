package com.example.movie.di

object KoinInstance {
    private var didStart = false
    fun start(koinAppDeclaration: () -> Unit) {
        if (!didStart) {
            koinAppDeclaration()
            didStart = true
        }
    }
}