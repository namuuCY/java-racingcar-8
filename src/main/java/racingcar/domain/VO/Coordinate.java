package racingcar.domain.VO;

import java.util.Objects;
import racingcar.exception.CustomException;
import racingcar.exception.ExceptionCode;

public class Coordinate implements Comparable<Coordinate> {

    private final Integer coordinate;

    public Coordinate(Integer coordinate) {
        isValid(coordinate);
        this.coordinate = coordinate;
    }

    public int getCoordinate() {
        return coordinate;
    }

    @Override
    public int compareTo(Coordinate o) {
        return this.getCoordinate() - o.getCoordinate();
    }

    private void isValid(Integer coordinate) {
        if (coordinate >= 0) {
            return;
        }
        throw new CustomException(ExceptionCode.INVALID_COORDINATE);
    }

    public Coordinate moveForward(Integer distance) {

        Integer nextCoordinate = this.coordinate + distance;
        return new Coordinate(nextCoordinate);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Coordinate that = (Coordinate) o;
        return Objects.equals(coordinate, that.coordinate);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(coordinate);
    }
}
