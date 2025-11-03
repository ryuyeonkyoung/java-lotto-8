package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.PurchasePrice;
import lotto.exception.ErrorMessage;

public class InputView {

    private static final String DELIMITER = ",";

    private static final String INPUT_PURCHASE_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    private InputView() {
    }

    public static InputView create() {
        return new InputView();
    }

    public PurchasePrice readPurchasePrice() {
        printPriceInputInfo();
        String input = userInput();
        try{
            return PurchasePrice.of(Integer.parseInt(input));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER_FORMAT.getMessage());
        }
    }

    public List<Integer> readWinningNumbers() {
        printWinningNumbersInfo();
        String input = userInput();
        try {
            return Arrays.stream(input.split(DELIMITER))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER_FORMAT.getMessage());
        }
    }

    public int readBonusNumber() {
        printBonnusNumberInfo();
        String input = userInput();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER_FORMAT.getMessage());
        }
    }

    private String userInput() {
        String userInput = Console.readLine();
        validateBlank(userInput);
        System.out.println();
        return userInput;
    }

    private void validateBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.EXCEPTION_NOT_BLANK.getMessage());
        }
    }

    private void printPriceInputInfo() {
        System.out.println(INPUT_PURCHASE_PRICE_MESSAGE);
    }
    private void printWinningNumbersInfo() {
        System.out.println(INPUT_WINNING_NUMBERS_MESSAGE);
    }
    private void printBonnusNumberInfo() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
    }
}
