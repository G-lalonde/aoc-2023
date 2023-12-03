package day01

import readInput

private const val DAY_FILE_NAME = "day01"

fun main() {
    fun part1(input: List<String>): Int {
        var total = 0

        for (line in input) {
            total += line.firstNumber() * 10 + line.lastNumber()
        }

        return total
    }

    fun part2(input: List<String>): Int {
        var total = 0

        for (line in input) {
            val newLine = line
                .replace("one", "o1e")
                .replace("two", "t2o")
                .replace("three", "t3e")
                .replace("four", "f4r")
                .replace("five", "f5e")
                .replace("six", "s6x")
                .replace("seven", "s7n")
                .replace("eight", "e8t")
                .replace("nine", "n9e")

            total += newLine.firstNumber() * 10 + newLine.lastNumber()
        }

        return total
    }

    val testInput = readInput("${DAY_FILE_NAME}/${DAY_FILE_NAME}_test")

//    val resultPart1 = part1(testInput)
//    check(resultPart1 == 142) { "Got instead : $resultPart1" }

//    val resultPart2 = part2(testInput)
//    check(resultPart2 == 281) { "Got instead : $resultPart2" }

    val input = readInput("${DAY_FILE_NAME}/${DAY_FILE_NAME}")
    println("Answer for part 1 : ${part1(input)}")
    println("Answer for part 2 : ${part2(input)}")
}

fun String.firstNumber(): Int {
    for (element in this) {
        try {
            return element.toString().toInt()
        } catch (e: NumberFormatException) {
            continue
        }
    }
    return 1
}

fun String.lastNumber(): Int {
    for (element in this.reversed()) {
        try {
            return element.toString().toInt()
        } catch (e: NumberFormatException) {
            continue
        }
    }
    return 1
}
