package racingcar.exception;

public class CustomException extends IllegalArgumentException {

    private String originalExceptionMessage;
    private ExceptionCode exceptionCode;

    public CustomException(String message, ExceptionCode exceptionCode) {
        super(message);
        this.exceptionCode = exceptionCode;
    }

    public CustomException(ExceptionCode exceptionCode) {
        super();
        this.exceptionCode = exceptionCode;
    }
}
