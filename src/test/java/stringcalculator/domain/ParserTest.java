package stringcalculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import stringcalculator.exception.BlankStringException;
import stringcalculator.exception.InvalidOperatorException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class ParserTest {
    @ParameterizedTest
    @DisplayName("입력값이 null 이거나 빈 문자열일 경우 예외를 발생시킨다.")
    @NullAndEmptySource
    void validateBlankString(String value) {
        assertThatExceptionOfType(BlankStringException.class)
                .isThrownBy(() -> new Parser(value));
    }

    @Test
    @DisplayName("입력된 연산자가 올바르지 않을 경우 예외를 발생시킨다.")
    void validateOperator() {
        Parser parser = new Parser("1 + 2 ( 4");

        assertThatExceptionOfType(InvalidOperatorException.class)
                .isThrownBy(parser::validateOperator);
    }

    @Test
    @DisplayName("문자열을 숫자로 형변환한다.")
    void convertToInt() {
        assertThat(Parser.convertToInt("3")).isEqualTo(3);
    }
}
