package lotto.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.PurchasePrice;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;

public class LottoService {

    // TODO: Lotto의 일급 컬렉션 분리 고려
    public List<Lotto> createLottos(int lottoNum) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoNum; i++) {
            lottos.add(Lotto.createRandomLotto());
        }
        return lottos;
    }

    public Map<Integer, Integer> getRanks(List<Lotto> publLottos, WinningLotto winningLotto) {
        Map<Integer, Integer> ranks = new HashMap<>();

        for (int i = 1; i <= 5; i++) {
            ranks.put(i,0);
        }

        for (Lotto publLotto : publLottos) {
            int corrNum = winningLotto.getCorrectNum(publLotto);
            boolean isBonusNumCorrect = winningLotto.isBonusNumCorrect(publLotto);
            int rank = getRank(corrNum, isBonusNumCorrect);
            ranks.put(rank, ranks.getOrDefault(rank,0) + 1);
        }
        return ranks;
    }

    // TODO: Rank 객체 전환 고려 (비즈니스 로직 다수 존재)
    public double getRevenueRate(Map<Integer, Integer> ranks, PurchasePrice purchasePrice) {
        return purchasePrice.getRevenueRate(getRevenue(ranks));
    }

    private int getRevenue(Map<Integer, Integer> ranks) {
        int revenue = 0;

        revenue += Rank.일등.getWinningMoney() * ranks.get(Rank.일등.getRank());
        revenue += Rank.이등.getWinningMoney() * ranks.get(Rank.이등.getRank());
        revenue += Rank.삼등.getWinningMoney() * ranks.get(Rank.삼등.getRank());
        revenue += Rank.사등.getWinningMoney() * ranks.get(Rank.사등.getRank());
        revenue += Rank.오등.getWinningMoney() * ranks.get(Rank.오등.getRank());

        return revenue;
    }

    // TODO: 하드코딩
    private int getRank(int corrNum, boolean isBonusNumCorrect) {
        if (corrNum == Rank.일등.getCorrectNumber()) {
            return 1;
        }
        if (corrNum == Rank.이등.getCorrectNumber() && isBonusNumCorrect) {
            return 2;
        }
        if (corrNum == Rank.삼등.getCorrectNumber()) {
            return 3;
        }
        if (corrNum == Rank.사등.getCorrectNumber()) {
            return 4;
        }
        if (corrNum == Rank.오등.getCorrectNumber()) {
            return 5;
        }
        return -1;
    }
}
