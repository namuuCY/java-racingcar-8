package racingcar.domain.service;

public class RandomMoveStrategy implements MoveStrategy {

    private final NumberGenerator randomNumberGenerator;
    private final Integer THRESHOLD;
    private final Integer INCREMENT;

    public RandomMoveStrategy(NumberGenerator randomNumberGenerator, Integer THRESHOLD, Integer INCREMENT) {
        this.randomNumberGenerator = randomNumberGenerator;
        this.THRESHOLD = THRESHOLD;
        this.INCREMENT = INCREMENT;
    }

    @Override
    public Integer moveByStrategy() {
        Integer randomNumber = randomNumberGenerator.generate();
        if (canMove(randomNumber)) {
            return INCREMENT;
        }
        return 0;
    }

    private Boolean canMove(Integer randomNumber) {
        return randomNumber >= THRESHOLD;
    }
}
