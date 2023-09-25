package blackjack.view;

import blackjack.model.Player;
import blackjack.utils.RandomCardGenerator;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public static final int STANADARD = 21;
    private static Scanner scanner;

    public static void wantMoreCard(Player player) {
        System.out.println(player.getPlayerName()+"는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)");
        try {
            if (!player.canGetMoreCard()) {
                return;
            }

            if (!scanner.next().equals("y") && !scanner.next().equals("n")) {
                throw new IllegalArgumentException("y 혹은 n을 입력해주세요");
            }

            if (scanner.next().equals("y")) {
                player.getOneMoreCard(RandomCardGenerator.generateRandomCard());
                wantMoreCard(player);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            wantMoreCard(player);
        }
    }

    public static void testMoreCardAndGetBattingMoney(Player player, String isMoreCard, String inpuptBattingMoney) {
        Scanner scanner = testSetIn(isMoreCard);
        String moreCard = scanner.next();// 여부 결정이 가능하다

        if (moreCard.equals("y")) {
            player.getOneMoreCard(RandomCardGenerator.generateRandomCard());
        }
    }

    private static Scanner testSetIn(String isMoreCard) {
        System.setIn(new ByteArrayInputStream(isMoreCard.getBytes()));
        Scanner scanner = new Scanner(System.in);
        return scanner;
    }

    private static void testSetInMultipleInputs(InputStream sequenceInputStream) {
        System.setIn(sequenceInputStream); // setIn() 까지만 메서드에서 처리를 해주고, 입력값 확인은 나중에 진행하면 된다
    }

    public static void dealerGetMoreCard() {
        System.out.println("딜러는 16이하라 한장의 카드를 더 받았습니다.");
    }

    private static InputStream generateInputStreamFromString(List<String> strings) {
        List<InputStream> inputs = new ArrayList<>();
        for (String string : strings) {
            inputs.add(generateInputStream(string));
        }
        return new SequenceInputStream(Collections.enumeration(inputs));
    }

    private static InputStream generateInputStream(String string) {
        return new ByteArrayInputStream(string.getBytes());
    }


    public static void testMoreCard(Player pobi_player, List<String> inputsFromConsole) {
        // String으로 온 애들을 가장 먼저 처리해야 한다
        InputStream inputStream = generateInputStreamFromString(inputsFromConsole);
        testSetInMultipleInputs(inputStream); // setIn()까지 완료한 상황

        scanner = new Scanner(System.in);

        while (pobi_player.canGetMoreCard()) {
            System.out.println("카드 더 받을거야?");
            if (scanner.next().equals("y")) {
                pobi_player.getOneMoreCard(RandomCardGenerator.generateRandomCard());
                continue;
            }

            break;
        }

        return;
    }
}
