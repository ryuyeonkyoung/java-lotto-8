package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Rank;

public class OutputView {

    public static final String ATTENDANCE_PURCHASE_MESSAGE = "개를 구매했습니다.";
    public static final String ATTENDANCE_STATISTICS_MESSAGE = "당첨 통계\n---";
    public static final String ATTENDANCE_REVENUE_MESSAGE = "총 수익률은 %.1f%입니다."; // TODO: printRate에 적용


    private OutputView() {
    }

    public static OutputView create() {
        return new OutputView();
    }

    public void printPurchaseLottos(List<Lotto> lottos) {
        System.out.printf("%d" + ATTENDANCE_PURCHASE_MESSAGE, lottos.size());
        System.out.println();
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
        System.out.println();
    }

    public void printRanks(Map<Integer, Integer> ranks) {
        System.out.println(ATTENDANCE_STATISTICS_MESSAGE);
        System.out.println(Rank.오등.getWinningMessage() + " - " + ranks.get(5) + "개");
        System.out.println(Rank.사등.getWinningMessage() + " - " + ranks.get(4) + "개");
        System.out.println(Rank.삼등.getWinningMessage() + " - " + ranks.get(3) + "개");
        System.out.println(Rank.이등.getWinningMessage() + " - " + ranks.get(2) + "개");
        System.out.println(Rank.일등.getWinningMessage() + " - " + ranks.get(1) + "개");
    }

    public void printRate(double rate) {
        System.out.printf("총 수익률은 %.1f%%입니다.", rate);
    }
}