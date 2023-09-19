package blackjack;

public class Participant {
    protected ReceivedCards receivedCards;

    public Participant() {
        receivedCards = new ReceivedCards();
    }

    public void startWithTwoCards(Card card, Card otherCard) {
        receivedCards.addStartingCards(card, otherCard);
    }

    public int score() {
        return receivedCards.cardSum();
    }
}
