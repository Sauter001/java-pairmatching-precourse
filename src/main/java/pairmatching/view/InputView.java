package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.exception.MatchingException;
import pairmatching.parser.FunctionCommandParser;
import pairmatching.parser.Parser;

public class InputView {
    public String readFunctionCommand() {
        String prompt = "기능을 선택하세요.\n" +
                "1. 페어 매칭\n" +
                "2. 페어 조회\n" +
                "3. 페어 초기화\n" +
                "Q. 종료";
        return readWithRetry(prompt, new FunctionCommandParser());
    }

    public <T> T readWithRetry(String prompt, Parser<T> parser) {
        while (true) {
            try {
                System.out.println(prompt);
                String input = Console.readLine();
                return parser.parse(input);
            } catch (MatchingException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
