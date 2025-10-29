package racingcar.service;

import java.util.List;
import racingcar.controller.dto.ResponseDto;
import racingcar.domain.entity.Car;
import racingcar.domain.entity.Entry;
import racingcar.domain.service.MoveStrategy;

public class RacingCarService {

    private final MoveStrategy moveStrategy;

    public RacingCarService(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public ResponseDto race(List<String> names, Integer trials) {

        Entry entry = Entry.from(names, trials);
        ResponseDto response = ResponseDto.of(names);

        for (int i = 0; i < trials; i++) {
            handleTrial(entry, response, moveStrategy);
        }
        handleWinner(entry, response);

        return response;
    }

    private void handleTrial(Entry cars, ResponseDto response, MoveStrategy moveStrategy) {
        cars.moveAll(moveStrategy);
        List<Car> currentCars = cars.currentCarStatus();
        response.updateHistory(currentCars);
    }

    private void handleWinner(Entry cars, ResponseDto response) {
        List<Car> winners = cars.aggregateWinner();
        response.updateWinner(winners);
    }
}
