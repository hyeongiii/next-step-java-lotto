package stringcalculator.exception;

public class InvalidOperatorException extends IllegalArgumentException {
    private final static String EXCEPTION_MESSAGE_INVALID_OPERATION = "입력된 기호가 올바르지 않습니다. : ";

    public InvalidOperatorException(String operator) {
        super(EXCEPTION_MESSAGE_INVALID_OPERATION + operator);
    }
}
