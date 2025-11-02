package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;

public class LottoService {

    // TODO: Lotto의 일급 컬렉션 분리 고려
    public List<Lotto> createLottos(int lottoNum) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoNum; i++) {
            lottos.add(Lotto.createRandomLotto());
        }
        return lottos;
    }
}
