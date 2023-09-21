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

    private int getCardsSum() {
        return cards.stream()
                .mapToInt(card -> card.calculate())
                .sum();
    }

    public int twoCardsSum() { // 처음 2장
        if (hasAceCard() && getCardsSum() == 11) {
            return getCardsSum() + 10;
        }
        return getCardsSum();
    }

    public int totalCardsSum() { // 최종 카드의 합을 구하는 상황
        if ( hasAceCard() && getCardsSum() <= 11) { // ACE를 가지고 있다면 1 혹은 11로 계산이 가능하다
            return getCardsSum() + 10;
        }
        return getCardsSum();
    }

    private boolean hasAceCard() {
        return cards.stream()
                .anyMatch(card -> card.getCardNumber() == CardNumber.A);
    }
}
