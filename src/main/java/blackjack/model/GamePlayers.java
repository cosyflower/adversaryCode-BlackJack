package blackjack.model;

import blackjack.utils.RandomCardGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GamePlayers {
    private final List<Player> players;

    public GamePlayers(List<Player> players) {
        this.players = new ArrayList<>(players);
    }

    public void start() {
        players.stream()
                .forEach((player) -> player.start());
    }

    public boolean hasBlackJackWithTwoCards() {
        return players.stream()
                .anyMatch((player -> player.hasBlackJack()));
    }

    public List<Player> getBlackjackPlayer() { // 복수 플레이어 가능하기 때문
        List<Player> winnerPlayers = new ArrayList<>();
        players.stream()
                .filter(player -> player.hasBlackJack())
                .forEach(winnerPlayers::add);
        return winnerPlayers;
    }

    public void getNothing() {
        players.stream()
                .forEach(player -> player.getNothing());
    }

    public void getCards() {
        players.stream()
                .filter(player -> player.canGetMoreCard(player.totalScore()))
                .forEach(player -> InputView.wantMoreCard()); // InputView 에서는 카드를 더 받겠습니까? 를 전달해야 한다
    }
}
