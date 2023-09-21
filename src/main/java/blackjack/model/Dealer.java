package blackjack.model;

import blackjack.model.strategy.DealerStandard;
import blackjack.utils.RandomCardGenerator;
import blackjack.view.InputView;

public class Dealer extends Participant {
    public Dealer() {
        super();
        this.standardStrategy = new DealerStandard();
        this.battingMoney = 0;
    }

    public void getCards() {
        if (canGetMoreCard()) {
            InputView.dealerGetMoreCard();
            getOneMoreCard(RandomCardGenerator.generateRandomCard());
        }
    }
}
