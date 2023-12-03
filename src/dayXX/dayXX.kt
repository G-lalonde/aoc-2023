package dayXX

import readInput

private const val DAY_FILE_NAME = "dayXX"

fun main() {
    fun part1(input: List<String>): Int {

        return 1
    }

    fun part2(input: List<String>): Int {

        return 2
    }

    val testInput = readInput("$DAY_FILE_NAME/${DAY_FILE_NAME}_test")

    val resultPart1 = part1(testInput)
    check(resultPart1 == 1) { "Got instead : $resultPart1" }

    val resultPart2 = part2(testInput)
    check(resultPart2 == 2) { "Got instead : $resultPart2" }

    val input = readInput("$DAY_FILE_NAME/$DAY_FILE_NAME")
    println("Answer for part 1 : ${part1(input)}")
    println("Answer for part 2 : ${part2(input)}")
}
