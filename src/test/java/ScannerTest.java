import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class ScannerTest extends IOTest{

    void execute() {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        System.out.println(line);
    }

    @Test
    void SystemSetInTest() {
        systemIn("내가 입력한 값 확인하기" + "\n");
        execute();

        Assertions.assertThat(getOutput()).isEqualTo("내가 입력한 값 확인하기"+"\n");
    }

}
