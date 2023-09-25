package blackjack.view;

import blackjack.model.Participant;

import java.util.List;

public class OutputView {
    public static void printPlayerCardStatus(List<Participant> gamePlayers) {
        for (Participant gamePlayer : gamePlayers) {
            System.out.println(gamePlayer +"의 카드 : " + gamePlayer.getReceivedCards());
        }
    }
}
