package com.example.microspotify.practice.kotlin101

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val a = 5
//    a = 6

    var b: String? = "hello"
    b = "world"
    b = null

    var c = 5
//    c = null

    // collection has list, map, set
    val numbers: List<Int> = listOf(1, 2, 3) // [1, 2, 3]
//    numbers.add(4)
//    numbers.remove(3)

    val mutableNumbers: MutableList<Int> = mutableListOf(1, 2, 3)
    mutableNumbers.add(4)
    mutableNumbers.remove(3)
    mutableNumbers.removeAt(0)

    // map
    val colorBook = mapOf("red" to 1, "blue" to 2, "yellow" to 3)
//    colorBook["black"] = 4

    val mutableColorBook = mutableMapOf("red" to 1, "blue" to 2)
    mutableColorBook["black"] = 4
    mutableColorBook.remove("red")
    mutableColorBook["blue"] = 3

    // loop
    for (num in numbers) {
        println(num)
    }

    for ((idx, num) in numbers.withIndex()) {
        println("index is $idx, value is $num")
    }

    // operator
    numbers.forEach { num ->
        print("forEach: $num")
    }

    val rec = Rectangle(3.0, 4.0)
}

fun condition(x: Int) {
    when (x) {
        1 -> {
            print("x == 1")
            print("this is 1")
        }
        2 -> print("x == 2")
        else -> {
            print("x is neither 1 nor 2")
        }
    }

    when {
        x == 1 -> print("x == 1")
        x == 2 -> print("x == 2")
        x == 3 || x == 4 -> print("x == 3 or 4")
        x > 10 -> print("x > 10")
        else -> {
            print("x is neither 1 nor 2")
        }
    }
}

fun numberOfFish(numberOfFish: Int) {
    when (numberOfFish) {
        0  -> println("Empty tank")
        in 1..39 -> println("Got fish!")
        else -> println("That's a lot of fish!")
    }

    print("")
}

fun helloworld(a: Int, b: String) {
    println("asdasdas")
}

class Rectangle (
    private val height: Double,
    private val length: Double
) {
    val perimeter = (height + length) * 2

    fun calculateSize(): Double {
        return height * length
    }
}

interface Animal {
    val furColor: String
    fun bark(): String
}

interface Mammal {
    fun birth()
}

abstract class Dog constructor(val breed: String): Animal, Mammal {
    override fun bark(): String {
        return "Wu, Wu, Wu"
    }
}

class GoldenRetriever: Dog("Golden") {
    override val furColor: String = "Golden"


    override fun bark(): String {
        return "Wang, Wang, Wang"
    }

    override fun birth() {
        println("birth")
    }
}


fun double(x: Int): Int = 2 * x
