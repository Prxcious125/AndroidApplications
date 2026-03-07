package com.example.assignements

class Exercise2 {fun processList(
    numbers: List<Int>,
    predicate: (Int) -> Boolean
): List<Int> {
    return numbers.filter { predicate(it) }
}

    fun exercise2() {
        val nums = listOf(1, 2, 3, 4, 5, 6)

        val even = processList(nums) { it % 2 == 0 }
        println("Original list : $nums")
        println("Even numbers  : $even")

        val greaterThanThree = processList(nums) { it > 3 }
        println("Greater than 3: $greaterThanThree")

        val odd = processList(nums) { it % 2 != 0 }
        println("Odd numbers   : $odd")
    }
}