package blackjack;

import java.util.ArrayList;

public class Player extends Participant {
    private final String playerName;
    private int battingMoney;

    public Player(String name, int inputBattingMoney) {
        super();
        this.playerName = name;
        this.battingMoney = inputBattingMoney;
    }

}
