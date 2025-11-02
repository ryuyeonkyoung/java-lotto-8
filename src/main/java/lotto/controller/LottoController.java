package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.PurchasePrice;
import lotto.domain.WinningLotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void start() {
        PurchasePrice purchasePrice = inputView.inputPurchasePrice();
        List<Integer> winnigNumbers = inputView.inputWinningNumbers();
        Lotto lotto = new Lotto(winnigNumbers);
        int bonusNumber = inputView.inputBonusNumber();

        WinningLotto winningLotto = WinningLotto.of(lotto, bonusNumber);
//        List<Lotto> publLottos = lottoService.createLottos(purchasePrice.getPublLottoNum());

    }
}
