package blackjack.model;

import java.util.ArrayList;
import java.util.List;

public class GamePlayers {
    private final List<Player> players;

    public GamePlayers(List<Player> players) {
        this.players = new ArrayList<>(players);
    }
}
