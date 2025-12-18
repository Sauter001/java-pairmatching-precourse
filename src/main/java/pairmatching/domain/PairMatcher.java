package pairmatching.domain;

import java.util.*;

public class PairMatcher {
    private final Crews crews;
    private final MatchingHistories matchingHistories;

    public PairMatcher(Crews crews, MatchingHistories matchingHistories) {
        this.crews = crews;
        this.matchingHistories = matchingHistories;
    }

    public Pairs matchPairs() {
        Pairs pairs = crews.makePairs();
        return pairs;
    }
}
