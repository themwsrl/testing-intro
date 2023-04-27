class MainTest {

    @org.junit.jupiter.api.Test
    fun `extract category works for empty string`() {
        val result = extractCategory("")
        assert(result == "")
    }

    @org.junit.jupiter.api.Test
    fun `extract category works for dash delimited strings`() {
        val result = extractCategory("LM-30-Classe delle lauree magistrali in Ingegneria energetica e nucleare")
        assert(result == "LM-30")
    }

    @org.junit.jupiter.api.Test
    fun `extract category works for square brackets with dash delimited`() {
        val result = extractCategory("[87-270] - ECONOMIA AZIENDALE")
        assert(result == "87-270")
    }

    @org.junit.jupiter.api.Test
    fun `extract category works for squared brackets with subcategory`() {
        val result = extractCategory("[LM5-18] SCIENZE")
        assert(result == "LM5-18")
    }

    @org.junit.jupiter.api.Test
    fun `extract category works for squared brackets with category`() {
        val result = extractCategory("[LM5] SCIENZE")
        assert(result == "LM5")
    }

}