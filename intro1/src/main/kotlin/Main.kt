fun main(args: Array<String>) {
    println("Hello World!")

    //TODO write a program (and tests!) that extracts category and course name from the following examples:
    //LM-30-Classe delle lauree magistrali in Ingegneria energetica e nucleare
    //[87-270] - ECONOMIA AZIENDALE
    //[LM5-18] SCIENZE
    //[LM5] SCIENZE
}

fun extractCategory(input: String): String {
    val result = extractFromSquareBrackets(input)
    return if (result != input) {
        result
    } else {
        extractFromDashes(result)
    }

}

fun extractFromSquareBrackets(input: String): String {
    return input.split("]")[0].replace(oldChar = '[', newChar = ' ').trim()
}

fun extractFromDashes(input: String): String {
    val lastDashIndex = input.indexOfLast { it == '-' }
    return if (lastDashIndex == -1) {
        input
    } else {
        input.substring(startIndex = 0, endIndex = lastDashIndex)
    }
}