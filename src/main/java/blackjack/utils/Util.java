package blackjack.utils;

public class Util {

    public static StringBuilder buildLineWithWhiteSpace(StringBuilder stringBuilder, int cardValue, String shape) {
        stringBuilder.append(cardValue);
        stringBuilder.append(" ");
        stringBuilder.append(shape);

        return stringBuilder;
    }
}
