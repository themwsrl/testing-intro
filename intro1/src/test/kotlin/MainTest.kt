import assertk.assertThat
import assertk.assertions.isEqualTo

class MainTest {

    @org.junit.jupiter.api.Test
    fun `extract category works for empty string`() {
        val result = extractCategory("")
        assertThat(result).isEqualTo("")
    }

    @org.junit.jupiter.api.Test
    fun `extract category works for dash delimited strings`() {
        val result = extractCategory("LM-30-Classe delle lauree magistrali in Ingegneria energetica e nucleare")
        assertThat(result).isEqualTo("LM-30")
    }

    @org.junit.jupiter.api.Test
    fun `extract category works for square brackets with dash delimited`() {
        val result = extractCategory("[87-270] - ECONOMIA AZIENDALE")
        assertThat(result).isEqualTo("87-270")
    }

    @org.junit.jupiter.api.Test
    fun `extract category works for squared brackets with subcategory`() {
        val result = extractCategory("[LM5-18] SCIENZE")
        assertThat(result).isEqualTo("LM5-18")
    }

    @org.junit.jupiter.api.Test
    fun `extract category works for squared brackets with category`() {
        val result = extractCategory("[LM5] SCIENZE")
        assertThat(result).isEqualTo("LM5")
    }

    @org.junit.jupiter.api.Test
    fun `extractFromSquareBrackets for empty string`() {
        val result = extractFromSquareBrackets("")
        assertThat(result).isEqualTo("")
    }

    @org.junit.jupiter.api.Test
    fun `extractFromSquareBrackets for string with spaces`() {
        val result = extractFromSquareBrackets("   ")
        assertThat(result).isEqualTo("")
    }

    @org.junit.jupiter.api.Test
    fun `extractFromSquareBrackets for string with open square bracket`() {
        val result = extractFromSquareBrackets("[ ")
        assertThat(result).isEqualTo("")
    }

    @org.junit.jupiter.api.Test
    fun `extractFromSquareBrackets for string with close square bracket`() {
        val result = extractFromSquareBrackets("]")
        assertThat(result).isEqualTo("")
    }

    @org.junit.jupiter.api.Test
    fun `extractFromSquareBrackets for string with bracket`() {
        val result = extractFromSquareBrackets("[]")
        assertThat(result).isEqualTo("")
    }

    @org.junit.jupiter.api.Test
    fun `extractFromSquareBrackets for string with category`() {
        val result = extractFromSquareBrackets("[LM5] SCIENZE")
        assertThat(result).isEqualTo("LM5")
    }

    @org.junit.jupiter.api.Test
    fun `extractFromSquareBrackets for string with subcategory`() {
        val result = extractFromSquareBrackets("[LM5-18] SCIENZE")
        assertThat(result).isEqualTo("LM5-18")
    }

    @org.junit.jupiter.api.Test
    fun `extractFromSquareBrackets for string without square brackets`() {
        val result = extractFromSquareBrackets("LM-30-Classe delle lauree magistrali in Ingegneria energetica e nucleare")
        assertThat(result).isEqualTo("LM-30-Classe delle lauree magistrali in Ingegneria energetica e nucleare")
    }
}