package blackjack;

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
}
