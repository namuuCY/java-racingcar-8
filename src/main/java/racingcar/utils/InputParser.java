package racingcar.utils;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import racingcar.exception.CustomException;
import racingcar.exception.ExceptionCode;

public class InputParser {

    private static final Pattern VALID_NAMES_PATTERN =
            Pattern.compile("^[a-zA-Z]+(,[a-zA-Z]+)*$");

    public static List<String> namesParser(String rawInput) {

        validate(rawInput);

        try {
            return Arrays.stream(rawInput.split(",")).toList();
        } catch (RuntimeException e) {
            throw new CustomException(e.getMessage(), ExceptionCode.UNEXPECTED_EXCEPTION);
        }

    }

    private static void validate(String rawInput) {
        if (VALID_NAMES_PATTERN.matcher(rawInput).matches()) {
            return;
        }
        throw new CustomException(ExceptionCode.INVALID_INPUT_NAMES);
    }

    public static Integer trialParser(String rawInput) {
        try {
            return Integer.parseInt(rawInput);
        } catch (NumberFormatException e) {
            throw new CustomException(e.getMessage(), ExceptionCode.INVALID_INPUT_NAMES);
        } catch (RuntimeException e) {
            throw new CustomException(e.getMessage(), ExceptionCode.UNEXPECTED_EXCEPTION);
        }
    }
}
