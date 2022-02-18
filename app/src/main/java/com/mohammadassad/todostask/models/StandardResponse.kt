package com.mohammadassad.todostask.models

data class StandardResponse<T>(
    val status: Int,
    val message: String,
    val body: T
)