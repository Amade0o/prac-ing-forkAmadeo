// Importaciones necesarias de JUnit 5
import static org.junit.jupiter.api.Assertions.assertEquals; // Para nombres más descriptivos
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName; // Incluye todos los asserts
import org.junit.jupiter.api.Test; // Asegúrate que la ruta sea correcta

import testing.partition.practico.ejercicio6.PatternIndex;

// Tests derivados con Pair-Wise Coverage para PatternIndex
class PatternIndexTest {

    // --- Tests cubriendo Pares con C1=b1 (subject=null) ---

    @Test
    @DisplayName("C1b1, C2b1: subject=null, pattern=null")
    void subjectNullPatternNull() {
        assertThrows(NullPointerException.class, () -> {
            PatternIndex.patternIndex(null, null);
        }, "Debe lanzar NPE si ambos son null");
    }

    @Test
    @DisplayName("C1b1, C2b2: subject=null, pattern=\"\"")
    void subjectNullPatternEmpty() {
        assertThrows(NullPointerException.class, () -> {
            PatternIndex.patternIndex(null, "");
        }, "Debe lanzar NPE si subject es null y pattern vacío");
    }

    @Test
    @DisplayName("C1b1, C2b3: subject=null, pattern=\"a\"")
    void subjectNullPatternNonEmpty() {
        assertThrows(NullPointerException.class, () -> {
            PatternIndex.patternIndex(null, "a");
        }, "Debe lanzar NPE si subject es null y pattern no vacío");
    }

    // --- Tests cubriendo Pares con C1=b2 (subject="") ---

    @Test
    @DisplayName("C1b2, C2b1: subject=\"\", pattern=null")
    void subjectEmptyPatternNull() {
        assertThrows(NullPointerException.class, () -> {
            PatternIndex.patternIndex("", null);
        }, "Debe lanzar NPE si subject vacío y pattern es null");
    }

    @Test
    @DisplayName("C1b2, C2b2, C4b2: subject=\"\", pattern=\"\"")
    void subjectEmptyPatternEmpty() {
        // Cubre C1b2, C2b2. C3 no aplica. C4=b2 (0 >= 0) implícitamente.
        // BUG DISCOVERY: Este test fallará con StringIndexOutOfBoundsException en la implementación original.
        // Esperamos 0 si se corrige el bug.
         assertEquals(0, PatternIndex.patternIndex("", ""), "Patrón vacío debe encontrarse en índice 0 en sujeto vacío");
    }

    @Test
    @DisplayName("C1b2, C2b3, C3b2, C4b1: subject=\"\", pattern=\"a\"")
    void subjectEmptyPatternNonEmpty() {
        // Cubre C1b2, C2b3. Como pattern no vacío y subject sí, C3=b2 y C4=b1.
        assertEquals(-1, PatternIndex.patternIndex("", "a"), "Patrón no vacío no debe encontrarse en sujeto vacío");
    }

    // --- Tests cubriendo Pares con C1=b3 (subject no vacío) ---

    @Test
    @DisplayName("C1b3, C2b1: subject=\"a\", pattern=null")
    void subjectNonEmptyPatternNull() {
        assertThrows(NullPointerException.class, () -> {
            PatternIndex.patternIndex("a", null);
        }, "Debe lanzar NPE si subject no vacío y pattern es null");
    }

    @Test
    @DisplayName("C1b3, C2b2, C4b2: subject=\"abc\", pattern=\"\"")
    void subjectNonEmptyPatternEmpty() {
        // Cubre C1b3, C2b2. C3 no aplica. C4=b2 (len(subj)>=len(patt)).
        // BUG DISCOVERY: Este test fallará con StringIndexOutOfBoundsException en la impl. original.
        // Esperamos 0 si se corrige.
         assertEquals(0, PatternIndex.patternIndex("abc", ""), "Patrón vacío debe encontrarse en índice 0 en sujeto no vacío");
    }

    // --- Tests cubriendo Pares C1b3 x C2b3 (subject no vacío, pattern no vacío) y C3/C4 ---

    @Test
    @DisplayName("C1b3, C2b3, C3b1, C4b2: subject=\"abc\", pattern=\"abc\"")
    void subjectSameAsStringPattern() {
        // Cubre C1b3, C2b3, C3b1, C4b2
        assertEquals(0, PatternIndex.patternIndex("abc", "abc"), "Patrón idéntico debe encontrarse en índice 0");
    }

    @Test
    @DisplayName("C1b3, C2b3, C3b2, C4b1: subject=\"a\", pattern=\"abc\"")
    void subjectShorterThanPattern() {
        // Cubre C1b3, C2b3, C3b2, C4b1
        assertEquals(-1, PatternIndex.patternIndex("a", "abc"), "Patrón más largo que sujeto no debe encontrarse");
    }

    @Test
    @DisplayName("C1b3, C2b3, C3b2, C4b2: subject=\"abc\", pattern=\"x\"")
    void patternNotFoundNonEmpty() {
        // Cubre C1b3, C2b3, C3b2, C4b2
        assertEquals(-1, PatternIndex.patternIndex("abc", "x"), "Patrón 'x' no está en 'abc'");
    }

    @Test
    @DisplayName("C1b3, C2b3, C3b3, C4b2: subject=\"abcde\", pattern=\"cd\"")
    void patternFoundMiddle() {
        // Cubre C1b3, C2b3, C3b3, C4b2
        assertEquals(2, PatternIndex.patternIndex("abcde", "cd"), "Patrón 'cd' debe encontrarse en índice 2");
    }

    // --- Tests Adicionales para asegurar cobertura de pares restantes o casos interesantes ---

    @Test
    @DisplayName("C1b3, C2b3, C3b3, C4b2: subject=\"abc\", pattern=\"a\"")
    void patternFoundAtStart() {
        // Asegura cobertura C3b3 con ocurrencia al inicio
        assertEquals(0, PatternIndex.patternIndex("abc", "a"), "Patrón 'a' debe encontrarse en índice 0");
    }

    @Test
    @DisplayName("C1b3, C2b3, C3b3, C4b2: subject=\"abc\", pattern=\"c\"")
    void patternFoundAtEnd() {
         // Asegura cobertura C3b3 con ocurrencia al final
         assertEquals(2, PatternIndex.patternIndex("abc", "c"), "Patrón 'c' debe encontrarse en índice 2");
    }

     @Test
    @DisplayName("Caso: Coincidencia parcial antes de fallar")
    void partialMatchThenFail() {
        // Caso específico dentro de C3b2, C4b2
        assertEquals(-1, PatternIndex.patternIndex("abxde", "abz"), "Patrón 'abz' no está en 'abxde'");
    }

     @Test
    @DisplayName("Caso: Ocurrencia múltiple")
    void multipleOccurrences() {
        // Caso específico dentro de C3b3, C4b2
        assertEquals(1, PatternIndex.patternIndex("abcabc", "bc"), "Patrón 'bc' se encuentra primero en índice 1");
    }
}