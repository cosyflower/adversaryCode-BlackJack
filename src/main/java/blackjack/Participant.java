package blackjack;

import blackjack.model.strategy.StandardStrategy;

public class Participant {
    protected ReceivedCards receivedCards;
    protected StandardStrategy standardStrategy;

    public Participant() {
        receivedCards = new ReceivedCards();
    }

    public void startWithTwoCards(Card card, Card otherCard) {
        receivedCards.addStartingCards(card, otherCard);
    }

    public int score() {
        return receivedCards.cardSum();
    }

    public boolean canGetMoreCard(int cardSum) {
        return standardStrategy.isMatchingStandard(cardSum);
    }

    public void getOneMoreCard(Card newCard) {
        receivedCards.addCard(newCard);
    }
}
