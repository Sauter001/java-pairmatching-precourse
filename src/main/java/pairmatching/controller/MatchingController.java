package pairmatching.controller;

import pairmatching.constant.MatchingConstant;
import pairmatching.domain.MatchingCriteria;
import pairmatching.exception.ErrorMessage;
import pairmatching.exception.MatchingException;
import pairmatching.service.MatchingService;
import pairmatching.service.MissionService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MatchingController {
    private final InputView inputView;
    private final OutputView outputView;
    private final MatchingService matchingService;
    private final MissionService missionService;

    public MatchingController(InputView inputView, MatchingService matchingService, MissionService missionService) {
        this.inputView = inputView;
        this.outputView = new OutputView();
        this.matchingService = matchingService;
        this.missionService = missionService;
    }

    public void run() {
        boolean waitNextCommand = true;
        while (waitNextCommand) {
            try {
                String command = inputView.readFunctionCommand();
                waitNextCommand = processCommand(command);
            } catch (MatchingException e) {
                outputView.printError(e);
            }
        }
    }

    private boolean processCommand(String command) {
        boolean keeping = true;

        if (command.equals(MatchingConstant.MATCHING_COMMAND)) {
            processMatching();
        }
        if (command.equals(MatchingConstant.READ_PAIR_COMMAND)) {
            readExistingMatch();
        }
        if (command.equals(MatchingConstant.INIT_PAIR_COMMAND)) {
            matchingService.clearHistories();
            outputView.displayInitialized();
        }
        if (command.equals(MatchingConstant.QUIT_COMMAND)) {
            keeping = false;
        }

        return keeping;
    }

    private void readExistingMatch() {
    }

    private void processMatching() {
        MatchingCriteria criteria = readMatchingCriteriaWithRetry();

    }

    private MatchingCriteria readMatchingCriteriaWithRetry() {
        while (true) {
            try {
                MatchingCriteria criteria = inputView.readMatchingCriteria();
                if (!missionService.isMissionExistInLevel(criteria)) {
                    throw new MatchingException(ErrorMessage.MISSION_NOT_EXIST);
                }
            } catch (MatchingException e) {
                outputView.printError(e);
                return inputView.readMatchingCriteria();
            }
        }
    }
}
