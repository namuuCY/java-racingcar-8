package racingcar.config;

import racingcar.controller.RacingCarController;
import racingcar.domain.service.RandomMoveStrategy;
import racingcar.domain.service.RandomNumberGenerator;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class AppConfig {

    private static final Integer LOWER_BOUND = 0;
    private static final Integer UPPER_BOUND = 9;
    private static final Integer THRESHOLD = 4;
    private static final Integer INCREMENT = 1;


    public static RacingCarController initController() {

        return new RacingCarController(
                new InputView(),
                new OutputView(),
                initApplicationService()
        );
    }

    private static RacingCarService initApplicationService() {
        return new RacingCarService(
                new RandomMoveStrategy(
                        new RandomNumberGenerator(LOWER_BOUND, UPPER_BOUND),
                        THRESHOLD,
                        INCREMENT
                )
        );
    }
}
