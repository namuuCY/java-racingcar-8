package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 공동_우승_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "3");
                    assertThat(output()).contains(
                            "pobi : -", "woni : ", "jun : -",     // 1회차
                            "pobi : --", "woni : -", "jun : --",    // 2회차
                            "pobi : --", "woni : --", "jun : ---",   // 3회차
                            "최종 우승자 : jun" // 3회차에서 jun만 전진
                    );
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, // 1회차 (pobi, jun 전진)
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, // 2회차 (모두 전진)
                STOP, MOVING_FORWARD, MOVING_FORWARD  // 3회차 (woni, jun 전진)
        );
    }

    @Test
    void 모두_멈춤_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("a,b,c", "2");
                    assertThat(output()).contains(
                            "a : ", "b : ", "c : ",     // 1회차
                            "a : ", "b : ", "c : ",     // 2회차
                            "최종 우승자 : a, b, c" // 모두 0칸이므로 공동 우승
                    );
                },
                STOP, STOP, STOP, // 1회차
                STOP, STOP, STOP  // 2회차
        );
    }

    @Test
    void 시도_횟수_숫자_아님_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도_횟수_0_이하_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이름_공백_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,,woni", "1")) // 쉼표(,) 연속 입력
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이름_공백_포함_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, ,woni", "1")) // 공백 이름
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
