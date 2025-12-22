package pairmatching.service;

import pairmatching.domain.course.Level;
import pairmatching.domain.course.MissionMap;
import pairmatching.repository.CrewRepository;

import java.util.List;

public class CrewService {
    private final CrewRepository crewRepository;
    private final MissionMap missionMap;

    public CrewService(MissionMap missionMap) {
        this.crewRepository = CrewRepository.getInstance();
        this.missionMap = missionMap;
    }

    public boolean hasMissionInLevel(Level level, String missionName) {
        List<String> missions = missionMap.getMissions(level);
        return missions.contains(missionName);
    }
}
