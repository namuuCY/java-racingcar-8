package racingcar.view;


import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String scanNames() {
        String messsage = nameAnnounce();
        System.out.println(messsage);
        return Console.readLine();
    }

    public String scanTrial() {
        String messsage = trialAnnounce();
        System.out.println(messsage);
        return Console.readLine();
    }

    private String nameAnnounce() {
        AnnouncementMessage message = AnnouncementMessage.INPUT_NAME;
        return message.getMessage();
    }

    private String trialAnnounce() {
        AnnouncementMessage message = AnnouncementMessage.INPUT_TRIAL;
        return message.getMessage();
    }
}
