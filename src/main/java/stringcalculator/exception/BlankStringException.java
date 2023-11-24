package stringcalculator.exception;

public class BlankStringException extends IllegalArgumentException {
    private static final String EXCEPTION_MESSAGE_BLANK_INPUT = "입력값이 빈 값이거나 공백으로만 이뤄졌습니다.";

    public BlankStringException() {
        super(EXCEPTION_MESSAGE_BLANK_INPUT);
    }
}
