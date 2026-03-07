package com.example.assignements

class Exercise1 {fun exercise1() {
    val numbers = listOf(1, 4, 7, 3, 9, 2, 8)

    println("Original list: $numbers")
    println("Squared numbers greater than 5:")

    numbers
        .filter { it > 5 }       // Step 1: keep only numbers > 5 → [7, 9, 8]
        .map { it * it }          // Step 2: square each → [49, 81, 64]
        .forEach { println(it) }  // Step 3: print each result
}
}