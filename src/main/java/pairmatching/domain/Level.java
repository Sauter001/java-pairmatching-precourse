package pairmatching.domain;

import pairmatching.exception.ErrorMessage;
import pairmatching.exception.MatchingException;

import java.util.Arrays;

public enum Level {
    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5");

    private final String name;

    Level(String name) {
        this.name = name;
    }

    // 추가 기능 구현

    public String getName() {
        return name;
    }

    public boolean equalsName(String otherName) {
        return this.name.equals(otherName);
    }

    public static Level getNameOf(String name) {
        return Arrays.stream(values())
                .filter(l -> l.equalsName(name))
                .findFirst()
                .orElseThrow(() -> new MatchingException(ErrorMessage.LEVEL_NOT_EXIST));
    }
}