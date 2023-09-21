package blackjack.utils;

import java.util.regex.Pattern;

public class Constants {
    public static String playerRegex = "(\\w+,?)+";
    public static Pattern playerPattern = Pattern.compile(playerRegex);

    public static String numberRegex = "([1-9])+([0-9])*";
    public static Pattern numberPattern = Pattern.compile(numberRegex);

}
