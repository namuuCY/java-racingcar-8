package racingcar.domain.entity;

import racingcar.domain.VO.CarName;
import racingcar.domain.VO.Coordinate;
import racingcar.domain.service.MoveStrategy;

public class Car implements Comparable<Car> {

    private final CarName carName;
    private Coordinate coordinate;

    private Car(CarName carName, Coordinate coordinate) {
        this.carName = carName;
        this.coordinate = coordinate;
    }

    public static Car initFrom(String name) {
        return new Car(
                new CarName(name),
                new Coordinate(0)
        );
    }

    public CarName getCarName() {
        return carName;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public int compareTo(Car target) {
        Coordinate targetCoordinate = target.getCoordinate();
        return coordinate.compareTo(targetCoordinate);
    }

    public void move(MoveStrategy strategy) {
        Integer increment = strategy.moveByStrategy();

        this.coordinate = coordinate.moveForward(increment);
    }


}
