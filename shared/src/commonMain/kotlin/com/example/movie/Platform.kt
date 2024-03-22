package com.example.movie

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform