fun exercise3()  {

    val words = listOf("apple", "cat", "banana", "dog", "elephant")

    println("Original words: $words")
    println("Words with length greater than 4:")

    words
        .associateWith { it.length }          
                                              
        .filter { it.value > 4 }             
        .forEach { (word, length) ->         
            println("$word has length $length")
        }
}
