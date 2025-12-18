package pairmatching.domain;

import pairmatching.constant.MatchingConstant;
import pairmatching.exception.ErrorMessage;
import pairmatching.exception.MatchingException;

import java.util.Set;

public class Pair {
    private final Set<Crew> crews;

    public Pair(Set<Crew> crews) {
        validateLength(crews);
        this.crews = crews;
    }

    private void validateLength(Set<Crew> crews) {
        if (crews.size() != MatchingConstant.DEFAULT_PAIR_LENGTH && crews.size() != MatchingConstant.REMAINED_PAIR_LENGTH) {
            throw new MatchingException(ErrorMessage.PAIR_LENGTH_EXCEED);
        }
    }

    public Set<Crew> getCrews() {
        return crews;
    }
}
