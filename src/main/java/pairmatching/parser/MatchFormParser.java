package pairmatching.parser;

import pairmatching.domain.course.Course;
import pairmatching.domain.course.Level;
import pairmatching.domain.input.MatchForm;
import pairmatching.exception.InvalidInputException;
import pairmatching.exception.PairException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MatchFormParser implements Parser<MatchForm> {
    private final static String DELIMITER = ",";
    public static final int TOKEN_LENGTH = 3;

    @Override
    public MatchForm parse(String input) {
        List<String> parts = Stream.of(input.split(DELIMITER))
                .filter(s -> !s.isEmpty())
                .map(String::trim)
                .collect(Collectors.toList());
        validateLength(parts);
        Course course = Course.from(parts.get(0));
        Level level = Level.from(parts.get(1));
        String mission = parts.get(2);

        return new MatchForm(course, level, mission);
    }

    private void validateLength(List<String> parts) {
        if (parts.size() != TOKEN_LENGTH) {
            throw new InvalidInputException("페어 매칭 (3개 입력 필요)");
        }
    }
}
