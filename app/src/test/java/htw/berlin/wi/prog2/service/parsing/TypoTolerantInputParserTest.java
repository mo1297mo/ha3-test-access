package htw.berlin.wi.prog2.service.parsing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TypoTolerantInputParserTest {

    private final TypoTolerantInputParser sut = new TypoTolerantInputParser();

    @Test
    @DisplayName("can make use of the provided different spellings or common typos")
    void idsAndCountFromInput() {

        // Input-Daten:
        String inputLine = "Ich hätte gerne eine Bowl mit REis, Qunioa, LAchs und nochmal Lacsh";
        Map<String, Long> keywordsToIds = Map.of(
                "Reis", 19L,
                "reis", 19L,
                "REis", 19L,
                "Quinoa", 87L,
                "quinoa", 87L,
                "Qunioa", 87L,
                "Qinoa", 87L,
                "Lachs", 77L,
                "LAchs", 77L,
                "Lacsh", 77L);

        Map<Long, Integer> expected = Map.of(
                19L, 1,
                87L, 1,
                77L, 2);
        Map<Long, Integer> actual = sut.idsAndCountFromInput(inputLine, keywordsToIds);

        assertEquals(expected, actual);
    }
}
