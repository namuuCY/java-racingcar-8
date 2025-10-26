package racingcar.exception;

public enum ExceptionCode {
    TEST_CODE("테스트 메세지 입니다.", "TEST_001"),
    INVALID_INPUT_NAME_NULL("입력값이 null로 들어왔습니다. 로직을 체크해주세요", "INPUT_001");

    private final String message;
    private final String code;

    ExceptionCode(String message, String code) {
        this.message = message;
        this.code = code;
    }
}
