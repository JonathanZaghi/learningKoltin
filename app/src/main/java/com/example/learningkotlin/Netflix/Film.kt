package com.example.learningkotlin.Netflix

data class Film(
    val name: String,
    val description: String,
    val evaluation: String,
    val director: String,
    val distribution: String
) : java.io.Serializable
