package blackjack.utils;

import java.util.Random;

public class RandomCardGenerator {
    public static final String[] numberRange = new String[] {"A", "TWO", "THREE", "FOUR", "FIVE",
            "SIX", "SEVEN", "EIGHT", "NINE", "JACK", "QUEEN", "KING", "AA"};
    public static final String[] shapeRange = new String[] {"스페이드", "다이아몬드", "하트", "클로버"};

    public static Random random = new Random();
    // Card를 만들어준다
    public static String generateRandomNumber() {
        // number, shape를 만들어야 한다
        int length = numberRange.length;
        return numberRange[random.nextInt(length)];
    }

    public static String generateRandomShape() {
        // number, shape를 만들어야 한다
        int length = shapeRange.length;
        return shapeRange[random.nextInt(length)];
    }

    public static String generateNumber(String numberTest) {
        return numberTest;
    }

    public static String generateShape(String shapeTest) {
        return shapeTest;
    }

}
