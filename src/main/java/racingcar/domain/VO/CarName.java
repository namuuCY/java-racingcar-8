package racingcar.domain.VO;

import java.util.Objects;
import racingcar.exception.CustomException;
import racingcar.exception.ExceptionCode;

/**
 * Car 객체의 이름 Value Object 입니다.
 */
public class CarName {

    private static final int UPPER_SIZE_LIMIT = 5;
    private static final String ALLOWED_CHAR_REGEX = "^[a-zA-Z]+$";

    private final String name;

    public CarName(String name) {

        isValid(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * 값 객체의 동등성을 판단합니다.
     *
     * @param o
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (Objects.isNull(o) || !(getClass() == o.getClass())) {
            return false;
        }
        CarName target = (CarName) o;
        return name.equals(target.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }


    /**
     * 이름의 유효성을 체크합니다.
     *
     * @param name
     * @throws CustomException 이름이 유효하지 않을 경우, CustomException을 throw 합니다.
     */
    private void isValid(String name) {
        checkNull(name);
        checkValidSize(name);
        checkValidContent(name);
    }

    /**
     * null 체크를 진행합니다.
     *
     * @param name
     * @throws CustomException null 값일 경우 throw
     */
    private void checkNull(String name) {
        if (Objects.nonNull(name)) {
            return;
        }
        throw new CustomException(ExceptionCode.INVALID_INPUT_NAME_NULL);
    }

    /**
     * 이름의 길이 체크를 진행합니다.
     *
     * @param name
     * @throws CustomException UPPER_SIZE_LIMIT 보다 클 경우 throw
     */
    private void checkValidSize(String name) {
        int length = name.length();

        if (length == 0 || length > UPPER_SIZE_LIMIT) {
            throw new CustomException(ExceptionCode.INVALID_INPUT_NAME_LENGTH);
        }

    }

    /**
     * 이름의 문자 체크를 진행합니다. 영어만 가능하고, 이외의 언어는 불가능 합니다.
     *
     * @param name
     * @throws CustomException 영어(대문자, 소문자) 이외의 이름을 입력 시 throw
     */
    private void checkValidContent(String name) {
        if (name.matches(ALLOWED_CHAR_REGEX)) {
            return;
        }
        throw new CustomException(ExceptionCode.NOT_ALLOWED_NAME);
    }

}
