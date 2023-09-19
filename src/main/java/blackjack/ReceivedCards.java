package blackjack;

import java.util.ArrayList;
import java.util.List;

public class ReceivedCards {
    private List<Card> cards = new ArrayList<>();

    public void addCard(Card newCard) {
        cards.add(newCard);
    }

    public void addStartingCards(Card card, Card otherCard) {
        cards.add(card);
        cards.add(otherCard);
    }

    public int cardSum() {
        return cards.stream()
                .mapToInt(card -> card.calculate())
                .sum();
    }
}
