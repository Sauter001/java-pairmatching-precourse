package pairmatching.handler;

import pairmatching.domain.course.MissionMap;
import pairmatching.service.CrewService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class HandlerFactory {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final MissionMap missionMap = new MissionMap();
    private static final CrewService crewService = new CrewService(missionMap);

    public static PairMatchHandler createPairMatchHandler() {
        return new PairMatchHandler(inputView, outputView, crewService);
    }
}
