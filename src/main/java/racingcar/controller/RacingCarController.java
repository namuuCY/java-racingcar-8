package racingcar.controller;

import java.util.List;
import racingcar.controller.dto.ResponseDto;
import racingcar.service.RacingCarService;
import racingcar.utils.InputParser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RacingCarService racingCarService;

    public RacingCarController(InputView inputView, OutputView outputView, RacingCarService racingCarService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingCarService = racingCarService;
    }

    public void run() {
        List<String> names = scanAndParseNames();
        Integer trials = scanAndParseTrials();

        ResponseDto response = racingCarService.race(names, trials);

        outputView.read(response, trials);
    }

    private List<String> scanAndParseNames() {
        String rawInput = inputView.scanNames();
        return InputParser.namesParser(rawInput);
    }

    private Integer scanAndParseTrials() {
        String trialInput = inputView.scanTrial();
        return InputParser.trialParser(trialInput);
    }
}
