package pairmatching.domain.course;

import pairmatching.exception.PairException;

import java.util.stream.Stream;

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
    public static Level from(String name) {
        return Stream.of(values())
                .filter(l -> l.name.equals(name))
                .findFirst()
                .orElseThrow(() -> new PairException("레벨(1 ~ 5 숫자) 형태로 입력해주십시오"));
    }

    public String getName() {
        return name;
    }
}
