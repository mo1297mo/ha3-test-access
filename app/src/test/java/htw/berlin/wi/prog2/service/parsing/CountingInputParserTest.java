package htw.berlin.wi.prog2.service.parsing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CountingInputParserTest {

    private final CountingInputParser sut = new CountingInputParser();

    @Test
    @DisplayName("can detect multiple occurrences of ingredients")
    void testCounting() {

        // Input-Daten:
        String inputLine = "Ich hätte gerne eine Bowl mit Reis Avocado Avocado und noch mehr Avocado";
        Map<String, Long> keywordsToIds = Map.of(
                "Reis", 19L,
                "Avocado", 87L,
                "Lachs", 77L);

        Map<Long, Integer> expected = Map.of(
                19L, 1,
                87L, 3);
        Map<Long, Integer> actual = sut.idsAndCountFromInput(inputLine, keywordsToIds);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("can deal with commas, dots, and dashes")
    void testCommaAndDot() {

        // Input-Daten:
        String inputLine = "Ich hätte gerne eine Reis-Bowl mit Avocado, Avocado, und noch mehr Avocado.";
        Map<String, Long> keywordsToIds = Map.of(
                "Reis", 19L,
                "Avocado", 87L,
                "Lachs", 77L);

        Map<Long, Integer> expected = Map.of(
                19L, 1,
                87L, 3);
        Map<Long, Integer> actual = sut.idsAndCountFromInput(inputLine, keywordsToIds);

        assertEquals(expected, actual);
    }
}
