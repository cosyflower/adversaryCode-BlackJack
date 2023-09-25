package ScannerV1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class IOTest {
    private ByteArrayOutputStream outputStreamCaptor;
    private PrintStream standardOut;

    protected void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    protected void testSetIn(InputStream inputStream) {
        System.setIn(inputStream);
    }

    protected InputStream generateTestInput(String inputTest) {
        return new ByteArrayInputStream(inputTest.getBytes());
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

    public InputStream multipleInput(String aString, String bString) {
        List<InputStream> inputStreams = Arrays.asList(
                generateTestInput(aString),
                generateTestInput(bString));
        return new SequenceInputStream(Collections.enumeration(inputStreams));
    }

    protected String getOutput() {
        return outputStreamCaptor.toString(); // toString() 으로 문자열로 변환해주는 역할이라고 할 수 있다
    }
}
