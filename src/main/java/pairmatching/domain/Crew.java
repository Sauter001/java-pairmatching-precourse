package pairmatching.domain;

import java.util.Objects;

public class Crew {
    private final Course course;
    private final String name;

    public Crew(Course course, String name) {
        this.course = course;
        this.name = name;
    }

    public Course getCourse() {
        return course;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Crew)) {
            return false;
        }

        Crew crew = (Crew) obj;
        return this.name.equals(crew.name) && this.course.equals(crew.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, course);
    }
}
