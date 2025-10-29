package racingcar.domain.entity;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.VO.Coordinate;
import racingcar.domain.service.MoveStrategy;


public class EntryTest {

    @Test
    void 입력값_중복_이름_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> {
                    Entry.from(
                            Arrays.asList("asdf", "asdf"),
                            1
                    );
                })
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Test
    void 단일_이름_예외_체크() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> {
                    Entry.from(Arrays.asList("asdf"), 3);
                })
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @ParameterizedTest
    @ValueSource(ints = {-4, 9999})
    void 횟수_유효성_테스트(Integer trial) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> {
                    Entry.from(
                            Arrays.asList("asdf", "qwer"),
                            trial
                    );
                })
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @ParameterizedTest
    @CsvSource({
            "7, 3, 4",
            "13, 8, 5"
    })
    void 이동_테스트(Integer expected, Integer first, Integer second) {
        // given
        Entry cars = Entry.from(Arrays.asList("asdf", "qwer"), 100);
        MoveStrategy stub = new StupMoveStrategy(first, first, second, second);

        // when
        for (int i = 0; i < 2; i++) {
            cars.moveAll(stub);
        }
        Coordinate coordinate = cars.findCurrentCoordinateOf(0);

        // then
        assertThat(coordinate.getCoordinate()).isEqualTo(expected);
    }


    @ParameterizedTest
    @CsvSource({
            "toby, poby, 3, 4, 1",
            "toby, poby, 3, 3, 2",
    })
    void 우승자_테스트(String p1, String p2, Integer d1, Integer d2, Integer expected) {
        Entry cars = Entry.from(Arrays.asList(p1, p2), 2);
        MoveStrategy stub = new StupMoveStrategy(d1, d2);
        cars.moveAll(stub);

        List<Car> winners = cars.aggregateWinner();

        assertThat(winners.size()).isEqualTo(expected);
    }


}
