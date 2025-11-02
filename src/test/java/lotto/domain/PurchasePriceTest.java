package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PurchasePriceTest {
    @DisplayName("구입금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void 구입금액이_1000원_단위가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> PurchasePrice.of(1234))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] ");
    }
}
