package racingcar.domain.entity;

import racingcar.domain.service.MoveStrategy;

public class MockMoveStrategy implements MoveStrategy {

    private final Integer increment;

    public MockMoveStrategy(Integer increment) {
        this.increment = increment;
    }

    // 테스트를 위해 random 이 아닌, 직접적으로 증가시킵니다.
    @Override
    public Integer moveByStrategy() {
        return increment;
    }
}
