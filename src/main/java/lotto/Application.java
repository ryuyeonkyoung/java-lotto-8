package lotto;

import lotto.config.AppConfig;
import lotto.controller.LottoController;
import lotto.exception.ErrorMessage;

public class Application {
    public static void main(String[] args) {
        try {
            LottoController lottoController = AppConfig.createController();
            lottoController.start();
        } catch (IllegalArgumentException e) {
            ErrorMessage.showErrorMessage(e.getMessage());
        }

    }
}
