fun main(args: Array<String>) {
    println("Hello World!")

    //TODO write a program (and tests!) that extracts category and course name from the following examples:
    //LM-30-Classe delle lauree magistrali in Ingegneria energetica e nucleare
    //[87-270] - ECONOMIA AZIENDALE
    //[LM5-18] SCIENZE
    //[LM5] SCIENZE
}

fun extractCategory(input: String): String {
    val result = extractFromSquareBrackets(input, 0)
    return if (result != input) {
        result
    } else {
        extractFromDashes(result, first = true)
    }
}

fun extractCourseName(input: String): String {
    val result = extractFromSquareBrackets(input, 1)
    return if (result != input) {
        result
    } else {
        extractFromDashes(result, first = false)
    }
}

fun extractFromSquareBrackets(input: String, groupIndex: Int): String {
    val trimmedInput = input.replace(oldChar = '[', newChar = ' ').trim()
    if (!trimmedInput.contains("]")) {
        return trimmedInput
    }
    return trimmedInput.split("]")[groupIndex].replace("- ", " ").trim()
}

fun extractFromDashes(input: String, first: Boolean): String {
    val lastDashIndex = input.indexOfLast { it == '-' }

    if (lastDashIndex == -1) {
        return input
    }

    return if (first) {
        input.substring(startIndex = 0, endIndex = lastDashIndex)
    } else {
        input.substring(startIndex = lastDashIndex + 1, endIndex = input.length)
    }
}