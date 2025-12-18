package pairmatching.exception;

public enum ErrorMessage {
    FILE_READING_FAILED("파일 읽기 실패"),
    INVALID_COMMAND("존재하지 않는 명령입니다.");
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
