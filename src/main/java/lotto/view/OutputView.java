package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Rank;

public class OutputView {


    public static final String ATTENDANCE_PURCHASE_MESSAGE = "%d개를 구매했습니다.\n";
    public static final String INFO_ATTENDANCE_STATISTICS_MESSAGE = "당첨 통계\n---";
    public static final String ATTENDANCE_STATISTICS_MESSAGE = "%s - %d개\n";
    public static final String ATTENDANCE_REVENUE_MESSAGE = "총 수익률은 %.1f%%입니다.";


    private OutputView() {
    }

    public static OutputView create() {
        return new OutputView();
    }

    public void printPurchaseLottos(List<Lotto> lottos) {
        System.out.printf(ATTENDANCE_PURCHASE_MESSAGE, lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
        System.out.println();
    }

    public void printRanks(Map<Integer, Integer> ranks) {
        System.out.println(INFO_ATTENDANCE_STATISTICS_MESSAGE);
        System.out.printf(ATTENDANCE_STATISTICS_MESSAGE, Rank.오등.getWinningMessage(), ranks.get(5));
        System.out.printf(ATTENDANCE_STATISTICS_MESSAGE, Rank.사등.getWinningMessage(), ranks.get(4));
        System.out.printf(ATTENDANCE_STATISTICS_MESSAGE, Rank.삼등.getWinningMessage(), ranks.get(3));
        System.out.printf(ATTENDANCE_STATISTICS_MESSAGE, Rank.이등.getWinningMessage(), ranks.get(2));
        System.out.printf(ATTENDANCE_STATISTICS_MESSAGE, Rank.일등.getWinningMessage(), ranks.get(1));
    }

    public void printRate(double rate) {
        System.out.printf(ATTENDANCE_REVENUE_MESSAGE, rate);
    }
}