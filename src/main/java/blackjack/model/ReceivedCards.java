package blackjack.model;

import blackjack.utils.Util;

import java.util.ArrayList;
import java.util.List;

public class ReceivedCards {
    public static final int CAN_BLACKJACK_SCORE = 11;
    public static final int ACE_CAN_BE_ELEVEN = 10;

    private List<Card> cards = new ArrayList<>();

    public String getCardDescription() {
        StringBuilder cardDescriptionLine = new StringBuilder();
        for (Card card : cards) {
            Util.buildLineWithWhiteSpace(cardDescriptionLine, card.getCardValue(), card.getShape());
            cardDescriptionLine.append(", ");
        }
        return cardDescriptionLine.toString().substring(0, cardDescriptionLine.length() - 2);
    }

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
        if (hasAceCard() && getCardsSum() == CAN_BLACKJACK_SCORE) {
            return getCardsSum() + ACE_CAN_BE_ELEVEN;
        }
        return getCardsSum();
    }

    public int totalCardsSum() { // 최종 카드의 합을 구하는 상황
        if ( hasAceCard() && getCardsSum() <= CAN_BLACKJACK_SCORE) { // ACE를 가지고 있다면 1 혹은 11로 계산이 가능하다
            return getCardsSum() + ACE_CAN_BE_ELEVEN;
        }
        return getCardsSum();
    }

    private boolean hasAceCard() {
        return cards.stream()
                .anyMatch(card -> card.getCardNumber() == CardNumber.A);
    }
}
