package pairmatching;

import pairmatching.controller.MatchingController;
import pairmatching.domain.MatchingHistories;
import pairmatching.domain.MissionsMap;
import pairmatching.service.MatchingService;
import pairmatching.service.MissionService;
import pairmatching.view.InputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        MissionsMap missionsMap = new MissionsMap();
        MatchingHistories matchingHistories = new MatchingHistories();
        MatchingService matchingService = new MatchingService(matchingHistories);
        MissionService missionService = new MissionService(missionsMap);
        MatchingController matchingController = new MatchingController(inputView, matchingService, missionService);
        matchingController.run();
    }
}
