package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {
    @DisplayName("보너스 번호의 숫자가 1 미만이면 예외가 발생한다.")
    @Test
    void 보너스_번호의_숫자가_1_미만이면_예외가_발생한다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> WinningLotto.of(lotto, -1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] ");
    }

    @DisplayName("보너스 번호의 숫자가 45 초과면 예외가 발생한다.")
    @Test
    void 보너스_번호의_숫자가_45_초과면_예외가_발생한다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> WinningLotto.of(lotto, 99))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] ");
    }
}
