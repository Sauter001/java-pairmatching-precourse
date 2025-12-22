package pairmatching.domain.course;

import java.util.*;

public class MissionMap {
    private final Map<Level, List<String>> missionMap = new EnumMap<>(Level.class);

    public MissionMap() {
        missionMap.put(Level.LEVEL1, Collections.unmodifiableList(Arrays.asList("자동차 경주", "로또", "숫자야구게임")));
        missionMap.put(Level.LEVEL2, Collections.unmodifiableList(Arrays.asList("장바구니", "결제", "지하철노선도")));
        missionMap.put(Level.LEVEL4, Collections.unmodifiableList(Arrays.asList("성능개선", "배포")));
    }

    public List<String> getMissions(Level level) {
        return missionMap.getOrDefault(level, Collections.emptyList());
    }
}
