package lotto.config;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class AppConfig {

    private AppConfig() {
    }

    public static LottoController createController() {
        return new LottoController(InputView.create(), OutputView.create(), createService());
    }

    public static LottoService createService() {
        return new LottoService();
    }
}
