package pairmatching.exception;

public enum ErrorMessage {
    FILE_READING_FAILED("파일 읽기 실패"),
    INVALID_COMMAND("존재하지 않는 명령입니다."),
    INVALID_INPUT("유효하지 않은 입력입니다."),
    COURSE_NOT_EXIST("입력한 강의가 존재하지 않습니다."),
    LEVEL_NOT_EXIST("입력한 강의에서 레벨이 존재하지 않습니다. 레벨(숫자)로 입력해주세요."),
    MISSION_NOT_EXIST("입력한 강의와 레벨에서 미션이 존재하지 않습니다."),
    PAIR_LENGTH_EXCEED("페어 수가 초과했습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
