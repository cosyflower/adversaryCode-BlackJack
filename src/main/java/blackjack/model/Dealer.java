package blackjack.model;

import blackjack.model.strategy.DealerStandard;

public class Dealer extends Participant {
    public Dealer(int inputBattingMoney) {
        super();
        this.standardStrategy = new DealerStandard();
        this.battingMoney = inputBattingMoney;
    }
}
