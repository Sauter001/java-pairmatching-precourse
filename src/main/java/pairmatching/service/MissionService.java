package pairmatching.service;

import pairmatching.domain.Level;
import pairmatching.domain.MatchingCriteria;
import pairmatching.domain.MissionsMap;

public class MissionService {
    private final MissionsMap missionsMap;

    public MissionService(MissionsMap missionsMap) {
        this.missionsMap = missionsMap;
    }

    public boolean isMissionExistInLevel(MatchingCriteria criteria) {
        return missionsMap.findMissionInLevel(criteria.getLevel(),  criteria.getMission()) != null;
    }
}
