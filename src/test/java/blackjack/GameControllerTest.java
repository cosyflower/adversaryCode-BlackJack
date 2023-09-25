package blackjack;

import blackjack.model.Card;
import blackjack.model.GamePlayers;
import blackjack.model.Player;
import blackjack.utils.RandomCardGenerator;
import blackjack.view.InputView;
import blackjack.view.OutputView;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class GameControllerTest {
    private GamePlayers gamePlayers;
    private Player pobi_Player;
    private Player honux_Player;

    @BeforeEach
    void setUp() {
        List<Player> testPlayers = new ArrayList<>();
        pobi_Player = new Player("pobi", 10000);
        honux_Player = new Player("honux", 20000);
        
        pobi_Player.startWithTwoCards(
                new Card(RandomCardGenerator.generateNumber("A"), 
                        RandomCardGenerator.generateShape("다이아몬드")),
                new Card(RandomCardGenerator.generateNumber("TWO"),
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

    private static Stream<Arguments> generateYesOrNoAboutCards() {
        return Stream.of(
                Arguments.of("y\n","n"),
                Arguments.of("n\n", "y")
        );
    }

    @ParameterizedTest
    @MethodSource("generateYesOrNoAboutCards")
    void can_Get_More_cards_And_Print_Status(String firstAnswer, String secondAnswer) {
        // 한 player에게 여러 번 한다
        List<String> inputsFromConsole = Arrays.asList(firstAnswer, secondAnswer);
        InputView.testMoreCard(pobi_Player, inputsFromConsole);

        System.out.println("pobi_Player.totalScore() = " + pobi_Player.totalScore());
        OutputView.printPlayerCardStatus(Arrays.asList(pobi_Player));
    }
}
