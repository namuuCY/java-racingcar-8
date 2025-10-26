package racingcar.exception;

public enum ExceptionCode {
    TEST_CODE("테스트 메세지 입니다.", "TEST_001"),
    INVALID_INPUT_NAME_NULL("입력값이 null로 들어왔습니다. 내부 로직을 체크해주세요", "NAME_001"),
    INVALID_INPUT_NAME_LENGTH("이름의 길이는 1이상 5이하이어야 합니다.", "NAME_002"),
    NOT_ALLOWED_NAME("이름에 영문을 제외한 문자가 포함되어 있습니다.", "NAME_003"),
    INVALID_COORDINATE("음수 좌표가 생성되었습니다. 내부 로직을 확인해주세요", "COORDINATE_001"),
    INVALID_RANDOM_NUMBER_SET("랜덤 숫자 생성 시 오류가 생겼습니다. 내부 로직을 확인해주세요", "RNG_001");

    private final String message;
    private final String code;

    ExceptionCode(String message, String code) {
        this.message = message;
        this.code = code;
    }
}
