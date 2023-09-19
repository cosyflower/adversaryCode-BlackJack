package blackjack;

import blackjack.utils.RandomCardGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CardTest {
    private String inputNumber;
    private String inputShape;
    @Test
    void card_Number_Constructor() {
        Card card = new Card("FIVE", "CLOVER");
        int value = card.calculate();
        Assertions.assertEquals(value, 5);
    }

    @Test
    void card_Number_Test() {
        CardNumber number = CardNumber.findNumber("A");
        Assertions.assertEquals(number, CardNumber.A);
    }

    @Test
    void generate_Card_Test() {
        inputNumber = RandomCardGenerator.generateNumber("A");
        inputShape = RandomCardGenerator.generateShape("클로버");

        Assertions.assertEquals(new Card(inputNumber, inputShape), new Card("A", "클로버"));
        Assertions.assertEquals(new Card(inputNumber, inputShape).calculate(), 1);
    }

    @Test
    void generate_random_card() {
        String randomNumber = RandomCardGenerator.generateRandomNumber();
        String randomShape = RandomCardGenerator.generateRandomShape();

        System.out.println("randomNumber = " + randomNumber);
        System.out.println("randomShape = " + randomShape);
    }
}
