package blackjack;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    // Player including player and dealer
    @Test
    void new_player() {
        Player player = new Player("pobi", 20000);
        player.startWithTwoCards(
                new Card("EIGHT", "하트"),
                new Card("NINE", "클로버"));
        int playerResult = player.score();
        Assertions.assertThat(playerResult).isEqualTo(17);
    }

    @Test
    void new_Player_With_ACE() {
        Player player = new Player("pobi", 20000);
        player.startWithTwoCards(
                new Card("A", "하트"),
                new Card("NINE", "클로버"));
        int playerResult = player.score();
        Assertions.assertThat(playerResult).isEqualTo(10);
    }

    @Test
    void new_Dealer() {
        Participant dealer = new Dealer();
        dealer.startWithTwoCards(
                new Card("EIGHT", "하트"),
                new Card("NINE", "클로버"));
        Assertions.assertThat(dealer.score()).isEqualTo(17);
    }

    @Test
    void new_Dealer_With_Ace() {
        Participant dealer = new Dealer();
        dealer.startWithTwoCards(
                new Card("A", "하트"),
                new Card("NINE", "클로버"));
        Assertions.assertThat(dealer.score()).isEqualTo(10);
    }
}
