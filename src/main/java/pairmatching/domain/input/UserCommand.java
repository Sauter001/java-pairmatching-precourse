package pairmatching.domain.input;

import pairmatching.exception.InvalidInputException;

import java.util.Arrays;

public enum UserCommand {
    PAIR_MATCHING("1"),
    PAIR_VIEW("2"),
    PAIR_INIT("3"),
    QUIT("Q");

    private final String key;

    UserCommand(String key) {
        this.key = key;
    }

    public static UserCommand from(String targetKey) {
        String upperTargetKey = targetKey.toUpperCase().trim();
        return Arrays.stream(values())
                .filter(u -> u.getKey().equals(upperTargetKey))
                .findFirst()
                .orElseThrow(InvalidInputException::new);
    }

    public String getKey() {
        return key;
    }
}
