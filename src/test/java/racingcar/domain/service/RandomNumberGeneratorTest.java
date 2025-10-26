package racingcar.domain.service;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RandomNumberGeneratorTest {

    @ParameterizedTest
    @CsvSource({
            "4, 2",
            "-1, 5"
    })
    void 생성자_유효성_검사(Integer lower, Integer upper) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> {
                    new RandomNumberGenerator(lower, upper);
                }).isInstanceOf(IllegalArgumentException.class)
        );
    }


}
