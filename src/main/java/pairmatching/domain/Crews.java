package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Crews {
    private static final int LAST_PAIR_LENGTH = 3;
    private List<Crew> crews;

    public Crews(List<Crew> crews) {
        this.crews = crews;
    }

    public static Crews fromFrontNames(CrewNames frontCrewNames) {
        return fromCourse(Course.FRONTEND, frontCrewNames);
    }

    public static Crews fromBackNames(CrewNames backCrewNames) {
        return fromCourse(Course.BACKEND, backCrewNames);
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

    private boolean isSizeOdd() {
        return this.crews.size() % 2 == 1;
    }

    public Iterator<Crew> getIterator() {
        return this.crews.iterator();
    }

    public Pairs makePairs() {
        if (isSizeOdd()) {
            return makeOddPairs();
        }
        return makeEvenPairs();
    }

    private Pairs makeOddPairs() {
        List<Pair> pairs = new ArrayList<>();
        int lastIndex = this.crews.size() - 1;
        for (int i = 0; i < this.crews.size() - LAST_PAIR_LENGTH; i += 2) {
            Set<Crew> crewSet = makeDefaultPair(i);
            Pair pair = new Pair(crewSet);
            pairs.add(pair);
        }

        Set<Crew> remainedSet = new  HashSet<>();
        remainedSet.add(this.crews.get(lastIndex - 2));
        remainedSet.add(this.crews.get(lastIndex - 1));
        remainedSet.add(this.crews.get(lastIndex));
        pairs.add(new Pair(remainedSet));

        return new Pairs(pairs);
    }

    private Pairs makeEvenPairs() {
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < this.crews.size(); i += 2) {
            Set<Crew> crewSet = makeDefaultPair(i);
            Pair pair = new Pair(crewSet);
            pairs.add(pair);
        }

        return new Pairs(pairs);
    }

    private Set<Crew> makeDefaultPair(int index) {
        Set<Crew> crewSet = new HashSet<>();
        crewSet.add(this.crews.get(index));
        crewSet.add(this.crews.get(index + 1));
        return crewSet;
    }
}
