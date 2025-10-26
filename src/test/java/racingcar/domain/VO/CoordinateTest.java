package racingcar.domain.VO;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CoordinateTest {

    @ParameterizedTest
    @CsvSource({
            "3, 4, false",
            "10, 4, true",
    })
    void 대소_비교_테스트(Integer a, Integer b, Boolean expected) {
        // given
        Coordinate coordinateA = new Coordinate(a);
        Coordinate coordinateB = new Coordinate(b);

        // when
        boolean isBigger = coordinateA.compareTo(coordinateB) > 0;

        // then
        assertThat(isBigger).isEqualTo(expected);
    }

    @Test
    void 좌표_유효성_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> {
                    Coordinate coordinate = new Coordinate(-1);
                }).isInstanceOf(IllegalArgumentException.class)
        );
    }

    /**
     * Integer.MAX_VALUE에서 더 이동하는 것을 방지
     */
    @Test
    void 좌표_이동_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> {
                    Coordinate current = new Coordinate(Integer.MAX_VALUE);
                    Coordinate next = current.moveForward(3);
                }).isInstanceOf(Exception.class)
        );
    }
}
