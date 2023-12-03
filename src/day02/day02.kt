package day02

import readInput

private const val DAY_FILE_NAME = "day02"

fun main() {

    val NUMBER_OF_RED = 12
    val NUMBER_OF_GREEN = 13
    val NUMBER_OF_BLUE = 14

    fun part1(input: List<String>): Int {

        var numberOfValidGames = 0

        for (line in input) {
            val gameId = line.split(":").first().split(" ").last().toInt()
            val sets = line.split(":").last()
            val tries = sets.split(";")
            var gameWasValid = true

            game@ for (game in tries) {
                val regexPattern = Regex("""(\d+) (\w+)""")
                val matches = regexPattern.findAll(game)

                for (match in matches) {
                    val number = match.groupValues[1].toInt()
                    val color = match.groupValues[2]

                    when (color) {
                        "red" -> if (number > NUMBER_OF_RED) {
                            gameWasValid = false
                            break@game
                        }

                        "green" -> if (number > NUMBER_OF_GREEN) {
                            gameWasValid = false
                            break@game
                        }

                        "blue" -> if (number > NUMBER_OF_BLUE) {
                            gameWasValid = false
                            break@game
                        }
                    }
                }
            }

            if (gameWasValid) {
                numberOfValidGames += gameId
            }
        }

        return numberOfValidGames
    }

    fun part2(input: List<String>): Int {
        var totalPower = 0

        for (line in input) {
            val sets = line.split(":").last()
            val tries = sets.split(";")

            var maxNumberOfRed = 0
            var maxNumberOfBlue = 0
            var maxNumberOfGreen = 0

            for (game in tries) {
                val regexPattern = Regex("""(\d+) (\w+)""")
                val matches = regexPattern.findAll(game)

                for (match in matches) {
                    val number = match.groupValues[1].toInt()
                    val color = match.groupValues[2]

                    when (color) {
                        "red" -> if (number > maxNumberOfRed) {
                            maxNumberOfRed = number
                        }

                        "green" -> if (number > maxNumberOfGreen) {
                            maxNumberOfGreen = number
                        }

                        "blue" -> if (number > maxNumberOfBlue) {
                            maxNumberOfBlue = number
                        }
                    }
                }
            }

            totalPower += maxNumberOfBlue * maxNumberOfGreen * maxNumberOfRed
        }

        return totalPower
    }

    val testInput = readInput("$DAY_FILE_NAME/${DAY_FILE_NAME}_test")

//    val resultPart1 = part1(testInput)
//    check(resultPart1 == 8) { "Got instead : $resultPart1" }

//    val resultPart2 = part2(testInput)
//    check(resultPart2 == 2286) { "Got instead : $resultPart2" }
//
    val input = readInput("$DAY_FILE_NAME/$DAY_FILE_NAME")
//    println("Answer for part 1 : ${part1(input)}")
    println("Answer for part 2 : ${part2(input)}")
}
