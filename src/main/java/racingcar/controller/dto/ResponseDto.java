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
        LinkedHashMap<String, List<Integer>> historyDetail = new LinkedHashMap<>();

        for (String name : names) {
            historyDetail.put(name, new ArrayList<>());
        }

        return new ResponseDto(
                historyDetail,
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
        List<Integer> coordinates = history.get(name);
        coordinates.add(coordinate.getCoordinate());
    }

    public void updateWinner(List<Car> winners) {
        List<String> nameList = winners.stream()
                .map(Car::getOriginalName)
                .toList();

        this.winners.addAll(nameList);
    }

}
