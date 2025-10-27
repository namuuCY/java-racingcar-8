package racingcar.domain.entity;


import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.VO.Coordinate;

public class CarTest {


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
        // given
        Car carA = Car.initFrom("testA");
        Car carB = Car.initFrom("testB");

        // when
        carA.move(new MockMoveStrategy(a));
        carB.move(new MockMoveStrategy(b));
        boolean isBigger = carA.compareTo(carB) > 0;

        // then
        assertThat(isBigger).isEqualTo(expected);
    }


    @ParameterizedTest
    @CsvSource({
            "3, 4, 7",
            "10, 5, 15"
    })
    void 이동_테스트(int prev, int increment, int expected) {
        Car car = Car.initFrom("test");

        car.move(new MockMoveStrategy(prev));
        car.move(new MockMoveStrategy(increment));
        Coordinate nextCoordinate = car.getCoordinate();

        assertThat(nextCoordinate.getCoordinate()).isEqualTo(expected);
    }


}
