package pairmatching.exception;

public class PairException extends IllegalArgumentException {

    public static final String ERROR_PREFIX = "[ERROR] ";

    public PairException(String message) {
        super(ERROR_PREFIX + message);
    }
}
