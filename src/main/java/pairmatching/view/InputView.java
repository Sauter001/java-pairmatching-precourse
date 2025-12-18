package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.domain.MatchingCriteria;
import pairmatching.domain.MissionsMap;
import pairmatching.exception.MatchingException;
import pairmatching.parser.FunctionCommandParser;
import pairmatching.parser.MatchingCriteriaParser;
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

    public MatchingCriteria readMatchingCriteria() {
        displayCoursesDetail();
        return readWithRetry("",  new MatchingCriteriaParser());
    }

    public <T> T readWithRetry(String prompt, Parser<T> parser) {
        while (true) {
            try {
                System.out.println(prompt);
                String input = Console.readLine();
                System.out.println();
                return parser.parse(input);
            } catch (MatchingException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void displayCoursesDetail() {
        System.out.println("#############################################");
        System.out.println("과정: 백엔드 | 프론트엔드");
        System.out.println("미션:");
        System.out.println("  - 레벨1: 자동차경주 | 로또 | 숫자야구게임");
        System.out.println("  - 레벨2: 장바구니 | 결제 | 지하철노선도");
        System.out.println("  - 레벨3: ");
        System.out.println("  - 레벨4: 성능개선 | 배포");
        System.out.println("  - 레벨5: ");
        System.out.println("############################################");
        System.out.println("과정, 레벨, 미션을 선택하세요.");
        System.out.println("ex) 백엔드, 레벨1, 자동차경주");
    }
}
