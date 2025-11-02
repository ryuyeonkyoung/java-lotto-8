package lotto.service;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoServiceTest extends NsTest {

    private final LottoService lottoService = new LottoService();

    @DisplayName("로또가 요청된 개수만큼 생성되었는지 확인한다..")
    @Test
    void 로또_개수_일치_확인() {
        int lottoNum = 3;
        List<Lotto> lottos = lottoService.createLottos(lottoNum);

        assertThat(lottoNum).isEqualTo(lottos.size());
    }


    @Override
    protected void runMain() {

    }
}
