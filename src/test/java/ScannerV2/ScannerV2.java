package ScannerV2;

import org.assertj.core.internal.bytebuddy.asm.Advice;
import org.junit.jupiter.params.provider.Arguments;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class ScannerV2 {
    // Multiple input

    public static InputStream createInputStream(String nameInput, String numberOfRoundsInput) {
        List<InputStream> inputStreams = Arrays.asList(
                generateUserInput(nameInput),
                generateUserInput(numberOfRoundsInput));
        return new SequenceInputStream(Collections.enumeration(inputStreams));
    }

    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    public static Stream<Arguments> provideNameAndNumberOfRounds() {
        return Stream.of(
                Arguments.of("포비,웨지 \n", 4),
                Arguments.of("포비,웨지\n", -1),
                Arguments.of("포비,웨지,웨지\n", 2)
        );
    }

}
