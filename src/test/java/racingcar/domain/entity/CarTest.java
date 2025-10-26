package racingcar.domain.entity;


import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.VO.Coordinate;
import racingcar.domain.service.MoveStrategy;

public class CarTest {

    class MockMoveStrategy implements MoveStrategy {

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

    // 생성자
    @ParameterizedTest
    @ValueSource(
            strings = {
                    "asdfasdf",
                    "1213",
                    "@#$%",
                    "우테테코"
            }
    )
    void 생성자_테스트(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> {
                    Car.initFrom(input);
                })
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @ParameterizedTest
    @CsvSource({
            "3, 4, false",
            "10, 4, true",
    })
    void 대소_비교_테스트(int a, int b, boolean expected) {
        Car carA = Car.of("testA", a);
        Car carB = Car.of("testB", b);

        boolean isBigger = carA.compareTo(carB) > 0;

        assertThat(isBigger).isEqualTo(expected);
    }


    @ParameterizedTest
    @CsvSource({
            "3, 4, 7",
            "10, 5, 15"
    })
    void 이동_테스트(int prev, int increment, int expected) {
        Car car = Car.of("test", prev);

        // 테스트를 위한 MoveStrategy 익명 클래스를 생성

        car.move(new MockMoveStrategy(increment));
        Coordinate nextCoordinate = car.getCoordinate();

        assertThat(nextCoordinate.getCoordinate()).isEqualTo(expected);
    }


}
