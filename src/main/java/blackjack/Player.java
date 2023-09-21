package blackjack;

import blackjack.model.strategy.PlayerStandard;

public class Player extends Participant {
    public static final int STANDARD_TWENTY_ONE = 21;

    private final String playerName;

    public Player(String name, int inputBattingMoney) {
        super();
        this.standardStrategy = new PlayerStandard();
        this.playerName = name;
        this.battingMoney = inputBattingMoney;
    }

}
