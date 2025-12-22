package pairmatching.exception;

public class TargetDoesNotExistException extends PairException {
    private static final String ERROR_FORMAT = "찾는 %s(이/가) 존재하지 않습니다.";

    public TargetDoesNotExistException(String target) {
        super(String.format(ERROR_FORMAT, target));
    }
}
