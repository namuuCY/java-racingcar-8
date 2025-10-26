package racingcar.domain.service;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class RandomMoveStrategyTest {

    class MockRandomNumberGenerator implements NumberGenerator {

        private final Integer mockNumber;

        public MockRandomNumberGenerator(Integer mockNumber) {
            this.mockNumber = mockNumber;
        }

        @Override
        public Integer generate() {
            return mockNumber;
        }
    }


    @ParameterizedTest
    @CsvSource({
            "3, 4, 1, 1",
            "5, 4, 3, 0",
            "8, 9, 2, 2"
    })
    void 랜덤_이동_테스트(Integer threshold, Integer mockNumber, Integer increment, Integer expected) {
        MoveStrategy randomMoveStrategy = new RandomMoveStrategy(
                new MockRandomNumberGenerator(mockNumber),
                threshold,
                increment
        );

        Integer result = randomMoveStrategy.moveByStrategy();

        assertThat(result).isEqualTo(expected);
    }


}
