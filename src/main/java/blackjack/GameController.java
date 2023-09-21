package blackjack;

import blackjack.model.GamePlayers;
import blackjack.model.Participant;
import blackjack.model.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameController {
    private GamePlayers gamePlayers;

    public GameController() {
        init();
        playGame();
        endGame();
    }

    private void init() {
        List<Player> validatedPlayers = new ArrayList<>();
        String[] validatedPlayerNames = InputController.inputPlayerNames(); // 이름을 입력 받고

        for (String name : validatedPlayerNames) { // 하나씩 베팅 금액을 확인한다(숫자인지 검증이 필요한 셈)
            Player validatedPlayer = InputController.inputPlayerBattingMoney(name);
            validatedPlayers.add(validatedPlayer);
        }

        gamePlayers = new GamePlayers(validatedPlayers);
    }

    private void endGame() {

    }

    private void playGame() {

    }

    private void setGamePlayers() {

    }


}
