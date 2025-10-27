package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputParserTest {

    @ParameterizedTest
    @ValueSource(strings = {
            "poby, asdf",
            "poby:asdf",
            "poby,asdf,"
    })
    void 이름_입력값_유효성_테스트(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> {

                })
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


}
