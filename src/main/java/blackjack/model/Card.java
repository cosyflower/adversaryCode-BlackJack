package blackjack.model;

import java.util.Objects;

public class Card {
    private final CardNumber cardNumber;
    private final String shape;

    public Card(String number, String shape) {
        this.cardNumber = CardNumber.findNumber(number);
        this.shape = shape;
    }

    public int calculate() {
        return cardNumber.getCardValue();
    }

    public CardNumber getCardNumber() {
        return cardNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return cardNumber == card.cardNumber && Objects.equals(shape, card.shape);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardNumber, shape);
    }
}
