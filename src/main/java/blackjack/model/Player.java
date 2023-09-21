package blackjack.model;

import blackjack.model.strategy.PlayerStandard;

public class Player extends Participant {
    public static final double BATTING_RATE = 1.5;

    private final String playerName;

    public Player(String name, int inputBattingMoney) {
        super();
        this.standardStrategy = new PlayerStandard();
        this.playerName = name;
        this.battingMoney = inputBattingMoney;
    }

    public void getRaisedBattingMoney() {
        this.battingMoney *= BATTING_RATE;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerName='" + playerName + '\'' +
                '}';
    }


}
