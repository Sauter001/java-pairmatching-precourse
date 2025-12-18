package pairmatching.domain;

import pairmatching.exception.ErrorMessage;
import pairmatching.exception.MatchingException;
import pairmatching.util.ListUtil;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class MissionsMap {
    private final Map<Level, List<String>> map = new EnumMap<>(Level.class);

    public MissionsMap() {
        addMissionsOfLevel(Level.LEVEL1, ListUtil.listOf("자동차경주", "로또", "숫자야구게임"));
        addMissionsOfLevel(Level.LEVEL2, ListUtil.listOf("장바구니", "결제", "지하철노선도"));
        addMissionsOfLevel(Level.LEVEL4, ListUtil.listOf("성능개선", "배포"));
    }

    public String findMissionInLevel(Level level, String targetMission) {
        List<String> missions = map.get(level);
        if (missions == null || missions.isEmpty()) {
            throw new MatchingException(ErrorMessage.MISSION_NOT_EXIST);
        }

        return missions.stream()
                .filter(mission -> mission.equals(targetMission))
                .findFirst()
                .orElseThrow(() -> new MatchingException(ErrorMessage.MISSION_NOT_EXIST));
    }

    private void addMissionsOfLevel(Level level,  List<String> missions) {
        map.put(level, missions);
    }
}
