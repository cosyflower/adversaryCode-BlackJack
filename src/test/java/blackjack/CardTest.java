package blackjack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CardTest {
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
}
