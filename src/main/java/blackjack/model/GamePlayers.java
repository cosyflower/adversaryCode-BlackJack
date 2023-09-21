package blackjack.model;

import blackjack.utils.RandomCardGenerator;

import java.util.ArrayList;
import java.util.List;

public class GamePlayers {
    private final List<Player> players;

    public GamePlayers(List<Player> players) {
        this.players = new ArrayList<>(players);
    }

    public void start() {
        players.stream()
                .forEach((player) -> player.start());
    }
}
