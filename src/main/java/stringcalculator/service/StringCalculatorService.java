package stringcalculator.service;

import stringcalculator.domain.Operator;
import stringcalculator.domain.Parser;

public class StringCalculatorService {
    public static int runCalculator(String string) {
        Parser parser = new Parser(string);
        parser.validateOperator();

        return calculateStrings(parser.parserInput());
    }

    private static int calculateStrings(String[] values) {
        int result = Parser.convertToInt(values[0]);

        for (int i = 1; i < values.length; i += 2) {
            result = calculateDependsOnOperator(result, values[i], Parser.convertToInt(values[i + 1]));
        }

        return result;
    }

    private static int calculateDependsOnOperator(int num1, String symbol, int num2) {
        Operator operator = Operator.findOperator(symbol);
        return operator.calculate(num1, num2);
    }
}
