package pairmatching.service;

import pairmatching.constant.FileConstant;
import pairmatching.domain.*;

public class MatchingService {
    private final Crews frontCrews;
    private final Crews backCrews;
    private final MatchingHistories  matchingHistories;

    public MatchingService(MatchingHistories matchingHistories) {
        CrewNames frontCrewNames = CrewNames.fromFileName(FileConstant.FRONTEND_CREW_PATH);
        CrewNames backCrewNames = CrewNames.fromFileName(FileConstant.BACKEND_CREW_PATH);
        this.frontCrews = Crews.fromFrontNames(frontCrewNames);
        this.backCrews = Crews.fromBackNames(backCrewNames);
        this.matchingHistories = matchingHistories;
    }

    public Pairs matchPairs() {
        return null;
    }

    public void clearHistories() {
        this.matchingHistories.clear();
    }
}
