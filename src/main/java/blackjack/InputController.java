package blackjack;

import blackjack.model.Player;
import blackjack.utils.Constants;

import java.util.List;
import java.util.Scanner;

public class InputController {
    private static Scanner scanner = new Scanner(System.in);

    public static String[] inputPlayerNames() {
        try {
            String players = scanner.nextLine();
            if (!Constants.playerPattern.matcher(players).matches()) {
                throw new IllegalArgumentException("쉼표를 기준으로 작성해주세요");
            }
            return players.split(",");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputPlayerNames();
        }
    }

    public static Player inputPlayerBattingMoney(String validatedName) {
        try {
            System.out.println(validatedName +"의 베팅 금액은?");
            String battingMoney = scanner.nextLine();
            if (!Constants.numberPattern.matcher(battingMoney).matches()) {
                throw new IllegalArgumentException("베팅 금액을 입력해주세요");
            }

            return new Player(validatedName, Integer.parseInt(battingMoney));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputPlayerBattingMoney(validatedName);
        }
    }
}
