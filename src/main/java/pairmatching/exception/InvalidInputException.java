package pairmatching.exception;

public class InvalidInputException extends MatchingException {
    public InvalidInputException() {
        super(ErrorMessage.INVALID_INPUT);
    }
}
