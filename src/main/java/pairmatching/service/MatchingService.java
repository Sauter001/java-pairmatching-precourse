package pairmatching.service;

import pairmatching.constant.FileConstant;
import pairmatching.domain.*;
import pairmatching.exception.ErrorMessage;
import pairmatching.exception.MatchingException;

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

    public Pairs matchPairs(MatchingCriteria criteria) {
        Crews crewsOfCourse = findCrewOf(criteria.getCourse());
        crewsOfCourse.shuffle();

        PairMatcher pairMatcher = new PairMatcher(crewsOfCourse, matchingHistories);
        return pairMatcher.matchPairs();
    }

    private Crews findCrewOf(Course course) {
        if (course.equals(Course.FRONTEND)) {
            return frontCrews;
        }
        if (course.equals(Course.BACKEND)) {
            return backCrews;
        }
        throw new MatchingException(ErrorMessage.COURSE_NOT_EXIST);
    }

    public void clearHistories() {
        this.matchingHistories.clear();
    }
}
