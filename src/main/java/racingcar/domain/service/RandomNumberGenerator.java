package racingcar.domain.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.exception.CustomException;
import racingcar.exception.ExceptionCode;

public class RandomNumberGenerator implements NumberGenerator {

    private final Integer LOWER_BOUND;
    private final Integer UPPER_BOUND;

    public RandomNumberGenerator(Integer LOWER_BOUND, Integer UPPER_BOUND) {
        checkValidation(LOWER_BOUND, UPPER_BOUND);
        this.LOWER_BOUND = LOWER_BOUND;
        this.UPPER_BOUND = UPPER_BOUND;
    }

    private void checkValidation(Integer lowerBound, Integer upperBound) {
        if (lowerBound >= 0 && upperBound > lowerBound) {
            return;
        }
        throw new CustomException(ExceptionCode.INVALID_RANDOM_NUMBER_SET);
    }

    @Override
    public Integer generate() {
        return Randoms.pickNumberInRange(LOWER_BOUND, UPPER_BOUND);
    }
}
