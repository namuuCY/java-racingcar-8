package racingcar.domain.entity;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import racingcar.domain.VO.CarName;
import racingcar.domain.VO.Coordinate;
import racingcar.domain.service.MoveStrategy;
import racingcar.exception.CustomException;
import racingcar.exception.ExceptionCode;

public class CarList {

    private final List<Car> cars;
    private final Integer trial;

    private CarList(List<Car> cars, Integer trial) {
        validateArguments(cars, trial);
        this.cars = cars;
        this.trial = trial;
    }

    public static CarList from(List<String> inputNames, Integer trial) {

        List<Car> cars = inputNames.stream()
                .map(Car::initFrom)
                .toList();

        return new CarList(
                cars,
                trial
        );
    }

    private void validateArguments(List<Car> cars, Integer trial) {
        validateCarNames(cars);
        validateTrial(trial);
    }

    private void validateCarNames(List<Car> cars) {

        Integer originalSize = cars.size();
        validateCarSize(originalSize);

        Set<String> names = cars.stream()
                .map(Car::getCarName)
                .map(CarName::getName)
                .collect(Collectors.toSet());

        if (originalSize == names.size()) {
            return;
        }

        throw new CustomException(ExceptionCode.DUPLICATED_NAME);
    }

    private void validateCarSize(Integer originalSize) {
        if (originalSize > 1) {
            return;
        }
        throw new CustomException(ExceptionCode.NOT_ENOUGH_CAR_NAMES);
    }

    private void validateTrial(Integer trial) {
        if (trial > 0 && trial < 1000) {
            return;
        }
        throw new CustomException(ExceptionCode.INVALID_TRIAL_NUMBER);
    }

    public Coordinate findCurrentCoordinateOf(Integer index) {
        Car target = cars.get(index);
        return target.getCoordinate();
    }

    public void moveAll(MoveStrategy strategy) {
        cars.forEach(car -> {
            car.move(strategy);
        });
    }

    public List<Car> aggregateWinner() {
        Coordinate maxCoordinate = aggregateMaxCoordinate();

        return cars.stream()
                .filter(car -> {
                    Coordinate currentCoordinate = car.getCoordinate();
                    return currentCoordinate.equals(maxCoordinate);
                })
                .toList();
    }

    private Coordinate aggregateMaxCoordinate() {
        Car winner = cars.stream()
                .max(Car::compareTo)
                .orElseThrow(() ->
                        new CustomException(ExceptionCode.UNEXPECTED_EXCEPTION));

        return winner.getCoordinate();

    }


}
