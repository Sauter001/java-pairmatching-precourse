package pairmatching.controller;

import pairmatching.exception.MatchingException;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MatchingController {
    private final InputView inputView;
    private final OutputView outputView;

    public MatchingController(InputView inputView) {
        this.inputView = inputView;
        this.outputView = new OutputView();
    }

    public void run() {
        try {
            String command = inputView.readFunctionCommand();
        } catch (MatchingException e) {
            outputView.printError(e);
        }
    }
}
