package racingcar.domain.entity;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class CarListTest {


    @ParameterizedTest
    @ValueSource(strings = {
            "poby, asdf",
            "poby:asdf",
            "poby,asdf,"
    })
    void 입력값_유효성_테스트(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> {
                    new CarList();
                })
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "poby,poby",
            "poay,poby,pocy,pody,poey,pofy,pogy,poby",
    })
    void 입력값_중복_이름_테스트(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> {
                    new CarList();
                })
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "poby, asdf",
            "poby:asdf"
    })
    void 횟수_유효성_테스트(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> {
                    new CarList();
                })
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 단일_이름_예외_체크() {
        assertSimpleTest(() ->
                        assertThatThrownBy(() -> {
                            // todo : "poby"라는 단일 이름으로 만들어진 객체 생성시 생기는 문제
//                    new CarList();
                        })
                                .isInstanceOf(IllegalArgumentException.class)
        );
    }


    // 문제 : Car를 만들때
    @Test
    void 이동_테스트() {

    }


    @Test
    void 우승자_단일_테스트() {

    }

    @Test
    void 우승자_다수_테스트() {

    }

    // DTO 뽑아줘야 하고(?) -> DTO 는 Application Service에서.
}
