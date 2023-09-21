package blackjack;

import blackjack.model.Dealer;
import blackjack.model.GamePlayers;
import blackjack.model.Player;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    private GamePlayers gamePlayers;
    private Dealer dealer;

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

    private void playGame() {
        // 2장씩 지급 받는다
        gamePlayers.start();
        dealer.start();
//        OutputView.showParticipantsStatus(); // gamePlayers, dealer 카드 상황을 출력함
        checkCards();

    }

    private void checkCards() {
        // Players, Dealer 2장의 카드 합을 확인합니다
        // GamePlayers.getBlackjackPlayer() - 블랙잭이 존재하는 경우 플레이어 반환하는 메서드
        // Participants().hasBlackjack() - 픞페리어, 딜러 블랙잭 존재하는지 확인합니다

        // 딜러, 플레이어 모두 21인 상황이 발생한 경우 (게임 종료)
        if (gamePlayers.hasBlackJackWithTwoCards() && dealer.hasBlackJack()) {
            gamePlayers.getNothing();
            dealer.getNothing();
            return;
        }

        // 플레이어만 21이 발생한 경우 (게임 종료)
        if (gamePlayers.hasBlackJackWithTwoCards()) {
            List<Player> blackjackPlayers = gamePlayers.getBlackjackPlayer();
            for (Player player : blackjackPlayers) {
                player.getRaisedBattingMoney();
            }
            return;
        }

        // 딜러만 블랙잭인 경우 (카드 배부)
        if (dealer.hasBlackJack()) {
            distributeCards();
            return;

        }
        // 모두 블랙잭이 아닌 경우 (카드 배부)
        distributeCards();
    }

    private void distributeCards() {
        // 카드를 배부합니다
        // 플레이어가 카드를 받을 수 있는지 확인합니다
        gamePlayers.getCards();
        dealer.getCards();
        // 딜러가 카드를 받을 수 있는지 확인합니다
    }

    private void endGame() {
        // 승리자 확인

        // 베팅 금액 결산하기

    }



}
