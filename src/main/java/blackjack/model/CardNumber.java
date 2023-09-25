package blackjack.model;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum CardNumber {
    A("A", 1), TWO("TWO", 2), THREE("THREE", 3),
    FOUR("FOUR",4), FIVE("FIVE",5), SIX("SIX",6),
    SEVEN("SEVEN",7), EIGHT("EIGHT",8), NINE("NINE",9),
    JACK("JACK", 10), QUEEN("QUEEN", 10),
    KING("KING", 10);

    private static final Map<String, CardNumber> CardNumberMap =
            Collections.unmodifiableMap(Stream.of(values())
                    .collect(Collectors.toMap(CardNumber::getCardName, Function.identity())));

    public static CardNumber findNumber(String number) {
        return Optional.ofNullable(CardNumberMap.get(number))
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 카드 숫자 입니다"));
    }

    private int cardValue;
    private String cardName;

    CardNumber(String cardName, int cardValue) {
        this.cardName = cardName;
        this.cardValue = cardValue;
    }

    private String getCardName() {
        return cardName;
    }

    public int getCardValue() {
        return cardValue;
    }
}
