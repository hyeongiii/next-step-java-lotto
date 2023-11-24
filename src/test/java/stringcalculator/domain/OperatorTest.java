package stringcalculator.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OperatorTest {
    @Test
    @DisplayName("두 수를 더한다.")
    void add() {
        Operator operator = Operator.ADD;

        assertThat(operator.calculate(1, 2)).isEqualTo(3);
    }

    @Test
    @DisplayName("두 수를 뺀다.")
    void subtract() {
        Operator operator = Operator.SUB;

        assertThat(operator.calculate(3, 1)).isEqualTo(2);
    }

    @Test
    @DisplayName("두 수를 곱한다.")
    void multiply() {
        Operator operator = Operator.MUL;

        assertThat(operator.calculate(2, 3)).isEqualTo(6);
    }

    @Test
    @DisplayName("두 수를 나눈다.")
    void divide() {
        Operator operator = Operator.DIV;

        assertThat(operator.calculate(4, 3)).isEqualTo(1);
    }
}
