package blackjack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CardTest {
    @Test
    void card_Number_Constructor() {
        Card card = new Card(5, "CLOVER");
        int value = card.calculate();
        Assertions.assertEquals(value, 5);
    }

    @Test
    void card_Special_Construnctor() {
        Card card = new Card("A", "DIAMOND");
        int[] value = card.calculate();
        org.assertj.core.api.Assertions.assertThat(value).containsExactly(1, 11);
    }
}
