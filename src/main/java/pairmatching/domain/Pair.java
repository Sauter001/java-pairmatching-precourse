package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class Pair {
    private final List<Crew> crews;

    private Pair(List<Crew> crews) {
        this.crews = crews;
    }

    public static Pair of2(Crew crew1, Crew crew2) {
        List<Crew> crews = new ArrayList<>();
        crews.add(crew1);
        crews.add(crew2);
        return new Pair(crews);
    }

    public static Pair of3(Crew crew1, Crew crew2, Crew crew3) {
        List<Crew> crews = new ArrayList<>();
        crews.add(crew1);
        crews.add(crew2);
        crews.add(crew3);
        return new Pair(crews);
    }
}
