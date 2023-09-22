package ScannerV1;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public abstract class IOTest {
    private ByteArrayOutputStream outputStreamCaptor;
    private PrintStream standardOut;

    protected void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @BeforeEach
    void setUp() {
        standardOut = System.out;
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor)); // 출력해야 하는 스트림을 묶어두는 역할
    }

    @AfterEach
    void printResult() {
        System.setOut(standardOut); // 표준 출력으로 다시 변경한 다음에 출력해야 한다
        System.out.println(getOutput());
    }

    protected String getOutput() {
        return outputStreamCaptor.toString(); // toString() 으로 문자열로 변환해주는 역할이라고 할 수 있다
    }
}
