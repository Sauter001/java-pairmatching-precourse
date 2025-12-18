package pairmatching.domain;

import pairmatching.exception.ErrorMessage;
import pairmatching.exception.MatchingException;

import java.util.Arrays;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private final String name;

    Course(String name) {
        this.name = name;
    }

    // 추가 기능 구현

    public String getName() {
        return name;
    }

    public boolean equalsName(String courseName) {
        return this.name.equals(courseName);
    }

    public static Course getNameOf(String name) {
        return Arrays.stream(values())
                .filter(l -> l.equalsName(name))
                .findFirst()
                .orElseThrow(() -> new MatchingException(ErrorMessage.COURSE_NOT_EXIST));
    }
}
