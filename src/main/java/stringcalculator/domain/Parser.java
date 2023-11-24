package stringcalculator.domain;

import stringcalculator.exception.BlankStringException;
import stringcalculator.exception.InvalidOperatorException;

public class Parser {
    private final static String SEPARATOR = " ";
    private final static String LEGAL_OPERATOR = "+-*/";
    private final String[] parserInput;

    public Parser(String input) {
        validateBlankString(input);
        parserInput = split(input);
    }

    private static void validateBlankString(String input) {
        if (blankString(input)) {
            throw new BlankStringException();
        }
    }

    private static boolean blankString(String input) {
        return input == null || input.isBlank();
    }

    private String[] split(String str) {
        return str.split(SEPARATOR);
    }

    public void validateOperator() {
        for (int i = 1; i < parserInput.length; i += 2) {
            illegalOperator(parserInput[i]);
        }
    }

    private void illegalOperator(String operator) {
        if (!LEGAL_OPERATOR.contains(operator)) {
            throw new InvalidOperatorException(operator);
        }
    }

    public String[] parserInput() {
        return parserInput;
    }

    public static int convertToInt(String value) {
        return Integer.parseInt(value);
    }
}
