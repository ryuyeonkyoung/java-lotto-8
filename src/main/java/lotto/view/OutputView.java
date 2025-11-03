package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public class OutputView {

    public static final String ATTENDANCE_PURCHASE_MESSAGE = "개를 구매했습니다.";
    public static final String ATTENDANCE_STATISTICS_MESSAGE = "당첨 통계\n---";
    public static final String ATTENDANCE_REVENUE_MESSAGE = "총 수익률은 %d%입니다.";


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

    public void printStatistics() {
        System.out.println("---");

    }

    public void printRate(double rate) {
        System.out.printf("총 수익률은 %.1f%%입니다.", rate);
    }
}