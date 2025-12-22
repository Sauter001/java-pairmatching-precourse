package pairmatching.domain.course;

import pairmatching.exception.PairException;

import java.util.stream.Stream;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private final String name;

    public static Course from(String name) {
        return Stream.of(values())
                .filter(course -> course.name.equals(name))
                .findFirst()
                .orElseThrow(() -> new PairException("그러한 코스가 존재하지 않습니다."));
    }

    Course(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
