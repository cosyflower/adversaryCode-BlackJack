package blackjack;

import blackjack.utils.Constants;
import org.junit.jupiter.api.Test;

public class InputControllerTest {
    @Test
    void test_Regex() {
        boolean result = Constants.playerPattern.matcher("sunghun,pobi").matches();
        System.out.println("result = " + result);
    }

    @Test
    void input_Player_Names() {
        String[] strings = InputController.inputPlayerNames();
    }
}
