package lotto.exception;

public enum ErrorMessage {
    NOT_BLANK_INPUT("입력은 공백일 수 없습니다. 다시 입력해주세요."),
    EXCEPTION_NOT_BLANK("입력은 공백일 수 없습니다."),
    PRICE_UNIT_WRONG("구입 금액은 1000원 단위로 입력받을 수 있습니다."),
    LOTTO_WINNING_NUMBER_OUT_OF_RANDE("로또 번호는 6개여야 합니다."),
    LOTTO_NUMBER_OUT_OF_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    LOTTO_NUMBER_DUPLICATED("로또 번호는 중복되는 숫자를 입력할 수 없습니다."),
    NOT_NUMBER_FORMAT("숫자가 아닙니다.")
    ;

    private static final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = ERROR_PREFIX + message;
    }

    public String getMessage() {
        return message;
    }

    public static void showErrorMessage (String message) {
        System.out.println(message);
    }
}
