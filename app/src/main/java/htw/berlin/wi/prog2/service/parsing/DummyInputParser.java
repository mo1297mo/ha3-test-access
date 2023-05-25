package htw.berlin.wi.prog2.service.parsing;

import java.util.HashMap;
import java.util.Map;

public class DummyInputParser implements ExtendableInputParser {
    @Override
    public Map<Long, Integer> idsAndCountFromInput(String inputLine, Map<String, Long> keywordsToIds) {
        Map<Long, Integer> idsAndCount = new HashMap<>();
        if(inputLine.contains("Reis")) idsAndCount.put(keywordsToIds.get("Reis"), 1);
        if(inputLine.contains("Lachs")) idsAndCount.put(keywordsToIds.get("Lachs"), 1);
        return idsAndCount;
    }
}
