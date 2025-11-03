package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum Rank {
    // TODO: 이등을 제외하고는 false여도 조건 만족
    일등(1, 6, false,2000000000, "6개 일치 (2,000,000,000원)"),
    이등(2, 5, true,30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    삼등(3, 5, false,1500000, "5개 일치 (1,500,000원)"),
    사등(4, 4, false,50000, "4개 일치 (50,000원)"),
    오등(5, 3, false,5000, "3개 일치 (5,000원)"),
    ;

    private final int rank;
    private final int correctNumber;
    private final boolean isBonusNumCorrect;
    private final int winningMoney;
    private final String winningMessage;

    Rank(int rank, int correctNumber, boolean isBonusNumCorrect, int winningMoney, String winningMessage) {
        this.rank = rank;
        this.correctNumber = correctNumber;
        this.isBonusNumCorrect = isBonusNumCorrect;
        this.winningMoney = winningMoney;
        this.winningMessage = winningMessage;
    }

    public String getWinningMessage() {
        return winningMessage;
    }

    // TODO: static 테스트 용이성 고려
    public static Map<Integer, Integer> getRanks(List<Lotto> publLottos, WinningLotto winningLotto) {
        Map<Integer, Integer> ranks = new HashMap<>();

        for (int i = 1; i <= 5; i++) {
            ranks.put(i,0);
        }

        for (Lotto publLotto : publLottos) {
            int corrNum = winningLotto.getCorrectNum(publLotto);
            boolean isBonusNumCorrect = winningLotto.isBonusNumCorrect(publLotto);
            int rank = getRank(corrNum);
            ranks.put(rank, ranks.getOrDefault(rank,0) + 1);
        }
        return ranks;
    }

    public static double getRevenueRate(Map<Integer, Integer> ranks, PurchasePrice purchasePrice) {
        return purchasePrice.getRevenueRate(getRevenue(ranks));
    }

    private static int getRevenue(Map<Integer, Integer> ranks) {
        int revenue = 0;

        revenue += Rank.일등.winningMoney * ranks.get(Rank.일등.rank);
        revenue += Rank.이등.winningMoney * ranks.get(Rank.이등.rank);
        revenue += Rank.삼등.winningMoney * ranks.get(Rank.삼등.rank);
        revenue += Rank.사등.winningMoney * ranks.get(Rank.사등.rank);
        revenue += Rank.오등.winningMoney * ranks.get(Rank.오등.rank);

        return revenue;
    }

    private static int getRank(int corrNum) {
        if (corrNum == Rank.일등.correctNumber) {
            return 1;
        }
        if (corrNum == Rank.이등.correctNumber && Rank.이등.isBonusNumCorrect) {
            return 2;
        }
        if (corrNum == Rank.삼등.correctNumber) {
            return 3;
        }
        if (corrNum == Rank.사등.correctNumber) {
            return 4;
        }
        if (corrNum == Rank.오등.correctNumber) {
            return 5;
        }
        return -1;
    }
}
