package ScannerV2;

import blackjack.InputController;
import blackjack.model.Player;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.stream.Stream;

public class InputTest {


    public static Stream<Arguments> provideNameAndNumberOfRounds() {
        return Stream.of(
                Arguments.of("포비,웨지 \n", "4"),
                Arguments.of("포비,웨지\n", "-1"),
                Arguments.of("포비,웨지,웨지\n", "2")
        );
    }

    @ParameterizedTest(name = "입력 이름 : {0}, 입력 숫자 : {1}")
    @MethodSource("provideNameAndNumberOfRounds")
    void inputWithValidation(String inputName, String inputNumber) {
        System.setIn(ScannerV2.createInputStream(inputName, inputNumber)); // Scanner(System.in) 해당 스트림으로 지정된 상황
        Scanner scanner = new Scanner(System.in);
        String inputNames = scanner.nextLine();
        int number = scanner.nextInt();

        System.out.println("inputNames = " + inputNames);
        System.out.println("number = " + number);
    }


    @ValueSource(strings = "kingdom")
    @ParameterizedTest(name = "입력 : {0}")
    void bufferedReader(String input) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.setIn(ScannerV2.generateUserInput(input));
        Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.next());
    }

    public static Stream<Arguments> provideBattingMoney() {
        return Stream.of(
                Arguments.of("10000\n"),
                Arguments.of("20000\n"),
                Arguments.of("0900\n")
        );
    }

    @ParameterizedTest
    @MethodSource("provideBattingMoney")
    void input_Player_Batting_Money(String inputBattingMoney) {
        System.setIn(ScannerV2.generateUserInput(inputBattingMoney));
        Player sunghun = InputController.inputPlayerBattingMoney("sunghun");

        System.out.println(sunghun.getPlayerName());
        System.out.println(sunghun.getBattingMoney());
    }
}
