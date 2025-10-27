package racingcar.view;

import java.util.LinkedHashMap;
import java.util.List;
import racingcar.controller.dto.ResponseDto;

public class OutputView {

    public void read(ResponseDto response, Integer trials) {

        LinkedHashMap<String, List<Integer>> history = response.history();
        showResult(history, trials);

        List<String> winners = response.winners();
        showWinner(winners);
    }

    private void showResult(LinkedHashMap<String, List<Integer>> history, Integer trials) {
        readResultAnnouncement();
        String resultContent = buildResult(history, trials);
        System.out.println(resultContent);
    }

    private String buildResult(LinkedHashMap<String, List<Integer>> history, Integer trials) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < trials; i++) {

            circuitAndAppend(history, i, sb);
            sb.append("\n");
        }
        return sb.toString();
    }

    private void circuitAndAppend(
            LinkedHashMap<String, List<Integer>> history,
            int i,
            StringBuilder sb
    ) {

        for (String name : history.keySet()) {

            List<Integer> carHistory = history.get(name);
            Integer position = carHistory.get(i);

            String dashes = "-".repeat(position);

            sb.append(name)
                    .append(" : ")
                    .append(dashes)
                    .append("\n");
        }
    }

    private void readResultAnnouncement() {
        AnnouncementMessage result = AnnouncementMessage.OUTPUT_RESULT;
        String str = result.getMessage();
        System.out.println(str);
    }


    private void showWinner(List<String> winners) {
        String announcement = getWinnerAnnouncement();
        String winnerContent = buildWinners(winners);
        System.out.println(announcement + winnerContent);

    }

    private String buildWinners(List<String> winners) {
        return String.join(", ", winners);
    }


    private String getWinnerAnnouncement() {
        AnnouncementMessage winner = AnnouncementMessage.OUTPUT_WINNER;
        return winner.getMessage();

    }
}
