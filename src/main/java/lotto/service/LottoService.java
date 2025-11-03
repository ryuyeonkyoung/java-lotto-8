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



    // TODO: Rank 객체 전환 고려 (비즈니스 로직 다수 존재)

}
