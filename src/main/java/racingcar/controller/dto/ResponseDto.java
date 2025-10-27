package racingcar.controller.dto;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import racingcar.domain.VO.Coordinate;
import racingcar.domain.entity.Car;

public record ResponseDto(
        LinkedHashMap<String, List<Integer>> history,
        List<String> winners
) {

    public static ResponseDto of(List<String> names) {
        LinkedHashMap<String, List<Integer>> map = new LinkedHashMap<>();

        for (String name : names) {
            map.put(name, new ArrayList<>());
        }

        return new ResponseDto(
                map,
                new ArrayList<>()
        );
    }

    public void updateHistory(List<Car> cars) {
        cars.forEach(car -> {
                    String name = car.getOriginalName();
                    Coordinate coordinate = car.getCoordinate();
                    updateHistoryOfName(name, coordinate);
                }
        );
    }

    private void updateHistoryOfName(String name, Coordinate coordinate) {
        List<Integer> coordinateList = history.get(name);
        coordinateList.add(coordinate.getCoordinate());
    }

    public void updateWinner(List<Car> winnerCarList) {
        List<String> nameList = winnerCarList.stream()
                .map(Car::getOriginalName)
                .toList();

        winners.addAll(nameList);
    }

}
