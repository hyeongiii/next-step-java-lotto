package stringcalculator.util;

import stringcalculator.exception.BlankStringException;
import stringcalculator.exception.InvalidOperatorException;

public class StringUtility {
    private final static String SEPARATOR = " ";
    private final static String LEGAL_OPERATOR = "+-*/";

    public static void validateBlankString(String input) {
        if (blankString(input)) {
            throw new BlankStringException();
        }
    }

    private static boolean blankString(String input) {
        return input == null || input.isBlank();
    }

    public static String[] split(String str) {
        return str.split(SEPARATOR);
    }

    public static void validateOperator(String[] values) {
        for (int i = 1; i < values.length; i += 2) {
            illegalOperator(values[i]);
        }
    }

    private static void illegalOperator(String operator) {
        if (!LEGAL_OPERATOR.contains(operator)) {
            throw new InvalidOperatorException(operator);
        }
    }

    public static int convertToInt(String value) {
        return Integer.parseInt(value);
    }
}
