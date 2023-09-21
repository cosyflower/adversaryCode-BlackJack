package blackjack.model;

import blackjack.model.strategy.StandardStrategy;
import blackjack.utils.RandomCardGenerator;

public class Participant {
    public static final int BLACKJACK = 21;

    protected ReceivedCards receivedCards;
    protected StandardStrategy standardStrategy;
    protected int battingMoney;

    public int getBattingMoney() {
        return battingMoney;
    }

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

    public boolean canGetMoreCard() {
        return !hasBlackJack() && standardStrategy.isMatchingStandard(totalScore());
    }

    public void getOneMoreCard(Card newCard) {
        receivedCards.addCard(newCard);
    }

    public Boolean isBlackJack(int cardSum) {
        return cardSum == BLACKJACK;
    }

    public void start() {
        startWithTwoCards(
                RandomCardGenerator.generateRandomCard(),
                RandomCardGenerator.generateRandomCard()
        );
    }

    public boolean hasBlackJack() {
        return twoCardsScore() == BLACKJACK;
    }

    public void getNothing() {
        battingMoney = 0;
    }


}
