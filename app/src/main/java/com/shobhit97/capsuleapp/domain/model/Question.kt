package com.shobhit97.capsuleapp.domain.model

data class Question(
    val question: String,
    val options: List<String>,
    val answer: Int
)