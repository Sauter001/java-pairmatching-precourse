package pairmatching.parser;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.MatchingCriteria;
import pairmatching.domain.MissionsMap;
import pairmatching.exception.InvalidInputException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MatchingCriteriaParser implements Parser<MatchingCriteria> {
    private static final int TOKEN_LENGTH = 3;

    @Override
    public MatchingCriteria parse(String input) {
        List<String> tokens = Arrays.stream(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
        validateInputLength(tokens);
        Course course = Course.getNameOf(tokens.get(0));
        Level level = Level.getNameOf(tokens.get(1));
        String mission = tokens.get(2);

        return new MatchingCriteria(course, level, mission);
    }

    private void validateInputLength(List<String> tokens) {
        if (tokens.size() != TOKEN_LENGTH) {
            throw new InvalidInputException();
        }
    }
}
