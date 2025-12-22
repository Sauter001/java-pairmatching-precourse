package pairmatching.exception;

public class InvalidInputException extends PairException {
    private static final String DEFAULT_MESSAGE = "잘못된 입력입니다.";
    private static final String  MESSAGE_FORMAT = "잘못된 입력입니다: %s";

    public InvalidInputException() {
        super(DEFAULT_MESSAGE);
    }

    public InvalidInputException(String target) {
        super(String.format(MESSAGE_FORMAT, target));
    }
}
