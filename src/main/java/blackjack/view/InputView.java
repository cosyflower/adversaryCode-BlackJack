package blackjack.view;

import blackjack.model.Card;
import blackjack.model.Player;
import blackjack.utils.RandomCardGenerator;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static void wantMoreCard(Player player) {
        System.out.println(player.getPlayerName()+"는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)");
        try {
            if (!scanner.nextLine().equals("y") && !scanner.nextLine().equals("n")) {
                throw new IllegalArgumentException("y 혹은 n을 입력해주세요");
            }

            if (scanner.nextLine().equals("y")) {
                player.getOneMoreCard(RandomCardGenerator.generateRandomCard());
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            wantMoreCard(player);
        }
    }


    public static void dealerGetMoreCard() {
        System.out.println("딜러는 16이하라 한장의 카드를 더 받았습니다.");
    }
}
