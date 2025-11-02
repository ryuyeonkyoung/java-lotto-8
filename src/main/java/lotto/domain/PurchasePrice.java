package lotto.domain;

import lotto.exception.ErrorMessage;

public class PurchasePrice {

    private static final int PRICE_UNIT = 1000;

    private final int purchaseAmount;

    private PurchasePrice(int purchaseAmount) {
        validatePurchaseUnit(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public static PurchasePrice of(int purchaseAmount) {
        return new PurchasePrice(purchaseAmount);
    }

    public int getPublLottoNum() {
        return this.purchaseAmount / PRICE_UNIT;
    }

    private void validatePurchaseUnit(int purchaseAmount) {
        if (purchaseAmount % PRICE_UNIT != 0) {
            throw new IllegalArgumentException(ErrorMessage.PRICE_UNIT_WRONG.getMessage());
        }
    }
}
