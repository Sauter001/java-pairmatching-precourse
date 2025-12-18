package pairmatching.exception;

public class MatchingException extends IllegalArgumentException {

    private static final String ERROR_PREFIX = "[ERROR] ";

    public MatchingException(ErrorMessage errorMessage) {
        super(ERROR_PREFIX + errorMessage.getMessage());
    }
}
