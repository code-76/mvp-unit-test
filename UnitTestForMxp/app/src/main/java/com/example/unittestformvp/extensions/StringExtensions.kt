package com.example.unittestformvp.extensions

fun String.removeAll(name: String): String {
    return replace(name, "")
}