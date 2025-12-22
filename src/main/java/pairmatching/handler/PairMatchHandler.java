package pairmatching.handler;

import pairmatching.domain.input.MatchForm;
import pairmatching.exception.PairException;
import pairmatching.exception.TargetDoesNotExistException;
import pairmatching.service.CrewService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchHandler implements CommandHandler {
    private final InputView inputView;
    private final OutputView outputView;
    private final CrewService crewService;


    public PairMatchHandler(InputView inputView, OutputView outputView, CrewService crewService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.crewService = crewService;
    }

    @Override
    public void handle() {
        MatchForm matchForm = readMatchFormWithRetry();

    }

    private MatchForm readMatchFormWithRetry() {
        while (true) {
            try {
                MatchForm matchForm = inputView.readMatchForm();
                validateMission(matchForm);
                return matchForm;
            } catch (PairException e) {
                outputView.displayError(e);
                inputView.readMatchForm();
            }
        }
    }

    private void validateMission(MatchForm matchForm) {
        if (!crewService.hasMissionInLevel(matchForm.getLevel(), matchForm.getMission())) {
            throw new TargetDoesNotExistException("미션");
        }
    }
}
