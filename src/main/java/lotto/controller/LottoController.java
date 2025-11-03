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
        // 구입 금액
        PurchasePrice purchasePrice = inputView.inputPurchasePrice();
        List<Lotto> publLottos = lottoService.createLottos(purchasePrice.getPublLottoNum());
        outputView.printPurchaseLottos(publLottos);

        // 당첨 번호
        List<Integer> winnigNumbers = inputView.inputWinningNumbers();
        Lotto lotto = new Lotto(winnigNumbers);
        int bonusNumber = inputView.inputBonusNumber();
        WinningLotto winningLotto = WinningLotto.of(lotto, bonusNumber);

        // 순위 및 당첨 통계 계산
        Map<Integer, Integer> ranks = Rank.getRanks(publLottos,winningLotto);

        // 당첨 통계 출력
        outputView.printRanks(ranks);

        // 수익률
        double rate = Rank.getRevenueRate(ranks, purchasePrice);
        outputView.printRate(rate);
    }
}
