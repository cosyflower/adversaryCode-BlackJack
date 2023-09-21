package blackjack;

import blackjack.model.strategy.StandardStrategy;

public class Participant {
    public static final int BLACKJACK = 21;

    protected ReceivedCards receivedCards;
    protected StandardStrategy standardStrategy;
    protected int battingMoney;

    public Participant() {
        receivedCards = new ReceivedCards();
    }

    public void startWithTwoCards(Card card, Card otherCard) {
        receivedCards.addStartingCards(card, otherCard);
    }

    public int twoCardsScore() {
        return receivedCards.twoCardsSum();
    }

    public int totalScore() {
        return receivedCards.totalCardsSum();
    }

    public boolean canGetMoreCard(int cardSum) {
        return standardStrategy.isMatchingStandard(cardSum);
    }

    public void getOneMoreCard(Card newCard) {
        receivedCards.addCard(newCard);
    }

    public Boolean isBlackJack(int cardSum) {
        return cardSum == BLACKJACK;
    }
}
