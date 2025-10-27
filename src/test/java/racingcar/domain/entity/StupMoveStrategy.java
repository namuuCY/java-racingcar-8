package racingcar.domain.entity;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import racingcar.domain.service.MoveStrategy;

public class StupMoveStrategy implements MoveStrategy {

    private final Queue<Integer> stubQueue = new LinkedList<>();

    public StupMoveStrategy(Integer... integers) {
        stubQueue.clear();
        stubQueue.addAll(Arrays.asList(integers));
    }

    public Integer moveByStrategy() {
        return stubQueue.poll();
    }
}
