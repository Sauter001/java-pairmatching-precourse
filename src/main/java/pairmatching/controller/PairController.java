package pairmatching.controller;

import pairmatching.domain.input.UserCommand;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairController {
    private final InputView inputView;
    private final OutputView outputView;

    public PairController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        while (true) {
            UserCommand command = inputView.readFunctionSelection();
            command.handle();
            if (command.equals(UserCommand.QUIT)) {
                break;
            }
        }
    }
}
