package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Crews {
    private List<Crew> crews;

    public Crews(List<Crew> crews) {
        this.crews = crews;
    }

    public static Crews fromFrontNames(CrewNames frontCrewNames) {
        return fromCourse(Course.FRONTEND,  frontCrewNames);
    }

    public static Crews fromBackNames(CrewNames backCrewNames) {
        return fromCourse(Course.BACKEND,  backCrewNames);
    }

    private static Crews fromCourse(Course course, CrewNames crewNames) {
        List<Crew> crews = new ArrayList<>();
        Iterator<String> crewNamesIterator = crewNames.getIterator();

        while (crewNamesIterator.hasNext()) {
            String crewName = crewNamesIterator.next();
            crews.add(new Crew(course, crewName));
        }

        return new Crews(crews);
    }

    public void shuffle() {
        this.crews = Randoms.shuffle(crews);
    }
}
