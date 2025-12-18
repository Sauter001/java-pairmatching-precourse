package pairmatching.domain;

import java.util.HashMap;
import java.util.Map;

public class MatchingHistories {
    Map<MatchingCriteria, Pairs> histories = new HashMap<>();

    public void putMatching(MatchingCriteria criteria, Pairs pairs) {
        histories.put(criteria, pairs);
    }

    public void clear() {
        histories.clear();
    }
}
