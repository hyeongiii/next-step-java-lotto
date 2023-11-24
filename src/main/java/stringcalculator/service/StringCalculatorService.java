package stringcalculator.service;

import stringcalculator.domain.Operator;
import stringcalculator.util.StringUtility;

public class StringCalculatorService {
    public static int runCalculator(String string) {
        StringUtility.validateBlankString(string);
        String[] values = StringUtility.split(string);
        StringUtility.validateOperator(values);

        return calculateStrings(values);
    }

    private static int calculateStrings(String[] values) {
        int result = StringUtility.convertToInt(values[0]);

        for (int i = 1; i < values.length; i += 2) {
            result = calculateDependsOnOperator(result, values[i], StringUtility.convertToInt(values[i + 1]));
        }

        return result;
    }

    private static int calculateDependsOnOperator(int num1, String symbol, int num2) {
        Operator operator = Operator.findOperator(symbol);
        return operator.calculate(num1, num2);
    }
}
