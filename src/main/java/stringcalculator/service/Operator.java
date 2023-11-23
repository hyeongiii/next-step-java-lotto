package stringcalculator.service;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    ADD("+", (a, b) -> a + b),
    SUB("-", (a, b) -> a - b),
    MUL("*", (a, b) -> a * b),
    DIV("/", (a, b) -> a / b),
    UNKNOWN(null, null);

    private final String operator;
    private final BiFunction<Integer, Integer, Integer> calculateFunc;

    Operator(String operator, BiFunction<Integer, Integer, Integer> calculateFunc) {
        this.operator = operator;
        this.calculateFunc = calculateFunc;
    }

    public static Operator findOperator(String symbol) {
        return Arrays.stream(Operator.values())
                .filter(type -> type.operator != null)
                .filter(type -> symbol.equals(type.operator))
                .findFirst()
                .orElse(Operator.UNKNOWN);
    }

    public Integer calculate(Integer num1, Integer num2) {
        assert this != UNKNOWN;
        return this.calculateFunc.apply(num1, num2);
    }

}
