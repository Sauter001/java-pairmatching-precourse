package pairmatching.domain;

import java.util.Objects;

public class MatchingCriteria {
    private final Course course;
    private final Level level;
    private final String mission;

    public MatchingCriteria(Course course, Level level, String mission) {
        this.course = course;
        this.level = level;
        this.mission = mission;
    }

    public Level getLevel() {
        return level;
    }

    public String getMission() {
        return mission;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof MatchingCriteria)) return false;
        MatchingCriteria that = (MatchingCriteria) o;
        return course == that.course && level == that.level && Objects.equals(mission, that.mission);
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, level, mission);
    }
}
