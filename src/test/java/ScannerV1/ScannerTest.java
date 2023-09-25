package ScannerV1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Scanner;
import java.util.stream.Stream;

public class ScannerTest extends IOTest{
    private static Stream<Arguments> inputString() {
        return Stream.of(
                Arguments.of("내가 입력한 값\n"),
                Arguments.of("확인\n"),
                Arguments.of("되라\n")
        );
    }

    void execute() {
        System.out.println("물어볼 것을 확인하기");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        System.out.println(line);
    }

    @ParameterizedTest
    @MethodSource("inputString")
    void SystemSetInTest(String testedInput) {
        systemIn(testedInput);
        execute();

        Assertions.assertThat(getOutput()).isEqualTo("물어볼 것을 확인하기\n" + testedInput);
    }

}
