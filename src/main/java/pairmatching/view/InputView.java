package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.domain.input.UserCommand;
import pairmatching.exception.PairException;
import pairmatching.parser.Parser;
import pairmatching.parser.UserCommandParser;

public class InputView {
    public UserCommand readFunctionSelection() {
        displayFunctions();
        return readWithRetry("", new UserCommandParser());
    }

    private static void displayFunctions() {
        System.out.println("기능을 선택하세요.");
        System.out.println("1. 페어 매칭");
        System.out.println("2. 페어 조회");
        System.out.println("3. 페어 초기화");
        System.out.println("Q. 종료");
    }

    private <T> T readWithRetry(String prompt, Parser<T> parser) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = Console.readLine();
                return parser.parse(input);
            } catch (PairException pe) {
                System.out.println(pe.getMessage());
            }
        }
    }
}
