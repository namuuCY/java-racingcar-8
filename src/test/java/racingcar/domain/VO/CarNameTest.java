package racingcar.domain.VO;


import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CarNameTest {


    @ParameterizedTest
    @CsvSource({
            "test, true",
            "asdf, false"
    })
    void 동등성_테스트(String input, Boolean expected) {
        // given
        CarName original = new CarName("test");
        CarName target = new CarName(input);
        // when
        Boolean isEqual = original.equals(target);
        // then
        assertThat(isEqual).isEqualTo(expected);
    }

    @ParameterizedTest
    @EmptySource
    void 빈_값_테스트(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> {
                    CarName name = new CarName(input);
                })
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @NullSource
    void NULL_값_테스트(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> {
                    CarName name = new CarName(input);
                })
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 길이_제한_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> {
                    CarName name = new CarName("asdfas");
                })
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "우테코",
            "as1df",
            "@1a!",
            "a b"
    })
    void 영문_외_문자_테스트(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> {
                    CarName name = new CarName(input);
                })
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

}
