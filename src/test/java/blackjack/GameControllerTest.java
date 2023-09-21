package blackjack;

import blackjack.model.Card;
import blackjack.model.GamePlayers;
import blackjack.model.Player;
import blackjack.utils.RandomCardGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GameControllerTest {
    private GamePlayers gamePlayers;
    @BeforeEach
    void setUp() {
        List<Player> testPlayers = new ArrayList<>();
        Player pobi_Player = new Player("pobi", 10000);
        Player honux_Player = new Player("honux", 20000);
        
        pobi_Player.startWithTwoCards(
                new Card(RandomCardGenerator.generateNumber("A"), 
                        RandomCardGenerator.generateShape("다이아몬드")),
                new Card(RandomCardGenerator.generateNumber("JACK"),
                        RandomCardGenerator.generateShape("클로버"))
        );

        honux_Player.startWithTwoCards(
                new Card(RandomCardGenerator.generateNumber("TWO"),
                        RandomCardGenerator.generateShape("스페이드")),
                new Card(RandomCardGenerator.generateNumber("QUEEN"),
                        RandomCardGenerator.generateShape("하트"))
        );
        
        
        testPlayers.add(pobi_Player);
        testPlayers.add(honux_Player);
        
        gamePlayers = new GamePlayers(testPlayers);
    }

    @Test
    void check_Blackjack_Two_Cards() {
        Assertions.assertTrue(gamePlayers.hasBlackJackWithTwoCards());
        System.out.println("gamePlayers.getBlackjackPlayer() = " + gamePlayers.getBlackjackPlayer());
    }


}
