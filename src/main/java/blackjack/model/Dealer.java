package blackjack.model;

import blackjack.model.strategy.DealerStandard;

public class Dealer extends Participant {
    public Dealer() {
        super();
        this.standardStrategy = new DealerStandard();
        this.battingMoney = 0;
    }
}
