package blackjack;

import blackjack.utils.RandomCardGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    // Player including player and dealer
    private Player player;
    private Dealer dealer;

    @BeforeEach
    void setUp() {
        player = new Player("pobi", 20000);
        dealer = new Dealer(10000);
    }

    @Test
    void new_player() {
        player.startWithTwoCards(
                new Card("EIGHT", "하트"),
                new Card("NINE", "클로버"));
        int playerResult = player.twoCardsScore();
        Assertions.assertThat(playerResult).isEqualTo(17);
    }

    @Test
    void new_Player_With_ACE() {
        player.startWithTwoCards(
                new Card("A", "하트"),
                new Card("NINE", "클로버"));
        int playerResult = player.twoCardsScore();
        Assertions.assertThat(playerResult).isEqualTo(10);
    }

    @Test
    void new_Dealer() {
        dealer.startWithTwoCards(
                new Card("EIGHT", "하트"),
                new Card("NINE", "클로버"));
        Assertions.assertThat(dealer.twoCardsScore()).isEqualTo(17);
    }

    @Test
    void new_Dealer_With_Ace() {
        dealer.startWithTwoCards(
                new Card("A", "하트"),
                new Card("NINE", "클로버"));
        Assertions.assertThat(dealer.twoCardsScore()).isEqualTo(10);
    }

    @Test
    void player_with_Two_Cards() {
        player.startWithTwoCards(
                new Card("JACK", "하트"), // 10
                new Card("AA", "클로버")); // 11

        if (player.canGetMoreCard(player.twoCardsScore())) {
            player.getOneMoreCard(new Card(
                    RandomCardGenerator.generateNumber("NINE"),
                    RandomCardGenerator.generateShape("클로버")
            ));
        }

        Assertions.assertThat(player.twoCardsScore()).isEqualTo(21);
    }

    @Test
    void player_check_BlackJack() {
        player.startWithTwoCards(
                new Card("JACK", "하트"), // 10
                new Card("AA", "클로버")); // 11

        dealer.startWithTwoCards(
                new Card("JACK", "하트"), // 10
                new Card("AA", "클로버")); // 11

        Boolean isBlackjack = player.isBlackJack(player.twoCardsScore());
        Boolean isBlackjackDealer = dealer.isBlackJack(dealer.twoCardsScore());

        Assertions.assertThat(isBlackjack).isEqualTo(true);
        Assertions.assertThat(isBlackjackDealer).isEqualTo(true);
    }

    @Test
    void check_twoCardsSum_And_totalSum() {
        player.startWithTwoCards(
                new Card("JACK", "하트"), // 10
                new Card("A", "클로버")); // 1 or 11

        dealer.startWithTwoCards(
                new Card("A", "하트"), // 2
                new Card("SIX", "클로버")); // 6

        int twoCards = player.twoCardsScore();
        int dealerTwoCards = dealer.twoCardsScore();

        Assertions.assertThat(twoCards).isEqualTo(21);
        Assertions.assertThat(dealerTwoCards).isEqualTo(7);

        dealer.getOneMoreCard(new Card("THREE", "다이아몬드"));
        int dealerTotalScore = dealer.totalScore();
        Assertions.assertThat(dealerTotalScore).isEqualTo(20);

    }
}
