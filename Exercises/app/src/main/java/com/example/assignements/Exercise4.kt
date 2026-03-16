package com.example.assignements

class Exercise4 {data class Person(val name: String, val age: Int)

    fun exercise4() {

        val people = listOf(
            Person("Alice",   25),
            Person("Bob",     30),
            Person("Charlie", 35),
            Person("Anna",    22),
            Person("Ben",     28)
        )

        val filtered = people.filter { person ->
            person.name.startsWith("A") || person.name.startsWith("B")
        }

        println("People whose name starts with A or B:")
        filtered.forEach { println("  ${it.name}, age ${it.age}") }

        val averageAge = filtered
            .map { it.age }
            .average()

        println("Average age   : ${"%.1f".format(averageAge)}")
    }
}