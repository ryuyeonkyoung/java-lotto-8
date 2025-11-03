package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.PurchasePrice;
import lotto.domain.Rank;
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
        PurchasePrice purchasePrice = readPurchasePrice();
        List<Lotto> publLottos = createAndPrintLottos(purchasePrice);

        WinningLotto winningLotto = readAndCreateWinningLotto();

        Map<Integer, Integer> ranks = Rank.getRanks(publLottos,winningLotto);
        printRanks(ranks);
        printRate(ranks, purchasePrice);
    }

    private PurchasePrice readPurchasePrice () {
        return inputView.readPurchasePrice();
    }

    private List<Lotto> createAndPrintLottos(PurchasePrice purchasePrice) {
        List<Lotto> publLottos = lottoService.createLottos(purchasePrice.getPublLottoNum());
        outputView.printPurchaseLottos(publLottos);
        return publLottos;
    }

    private WinningLotto readAndCreateWinningLotto() {
        List<Integer> winnigNumbers = inputView.readWinningNumbers();
        int bonusNumber = inputView.readBonusNumber();
        Lotto lotto = new Lotto(winnigNumbers);
        return WinningLotto.of(lotto, bonusNumber);
    }

    private void printRanks(Map<Integer, Integer> ranks) {
        outputView.printRanks(ranks);
    }

    private void printRate(Map<Integer, Integer> ranks, PurchasePrice purchasePrice) {
        double rate = Rank.getRevenueRate(ranks, purchasePrice);
        outputView.printRate(rate);
    }

}
