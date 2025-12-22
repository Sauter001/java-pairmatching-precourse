package pairmatching.domain.input;

import pairmatching.domain.course.Course;
import pairmatching.domain.course.Level;

public class MatchForm {
    private final Course course;
    private final Level level;
    private final String mission;

    public MatchForm(Course course, Level level, String mission) {
        this.course = course;
        this.level = level;
        this.mission = mission;
    }

    public Course getCourse() {
        return course;
    }

    public Level getLevel() {
        return level;
    }

    public String getMission() {
        return mission;
    }
}
