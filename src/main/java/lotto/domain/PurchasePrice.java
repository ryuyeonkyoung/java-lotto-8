package lotto.domain;

import lotto.exception.ErrorMessage;

public class PurchasePrice {

    private static final int PRICE_UNIT = 1000;
    private static final int PERCENT_UNIT = 100;
    private static final int ZERO = 0;

    private final int purchaseAmount;

    private PurchasePrice(int purchaseAmount) {
        validatePurchaseUnit(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public static PurchasePrice of(int purchaseAmount) {
        return new PurchasePrice(purchaseAmount);
    }

    public int getPurchasedLottoNum() {
        return this.purchaseAmount / PRICE_UNIT;
    }

    public double getRevenueRate(int revenue) {
        if (purchaseAmount == ZERO) {
            return ZERO;
        }
        return (double) revenue / purchaseAmount * PERCENT_UNIT;
    }

    private void validatePurchaseUnit(int purchaseAmount) {
        if (purchaseAmount % PRICE_UNIT != ZERO) {
            throw new IllegalArgumentException(ErrorMessage.PRICE_UNIT_WRONG.getMessage());
        }
    }
}
