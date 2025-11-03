package lotto.domain;

import lotto.exception.ErrorMessage;

public class WinningLotto {

    private final static int LOTTO_MIN_NUM_INTENSION = 1;
    private final static int LOTTO_MAX_NUM_INTENSION = 45;

    private final Lotto lotto;
    private final int bonusNumber;

    private WinningLotto(Lotto lotto, int bonusNumber) {
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
        this.lotto = lotto;
    }

    public static WinningLotto of(Lotto lotto, int bonusNumber) {
        return new WinningLotto(lotto, bonusNumber);
    }

    public int getCorrectNum(Lotto userLotto) {
        int correctNum = 0;
        for (int n : lotto.getNumbers()) {
            if (userLotto.isContainNum(n)) {
                correctNum++;
            }
        }
        return correctNum;
    }

    public boolean isBonusNumCorrect(Lotto userLotto) {
        return userLotto.getNumbers().contains(bonusNumber);
    }

    // TODO: LottoNumber 객체 만든 후 테스트 코드 수정해도 되는지 확인하기
    private void validateBonusNumber(int bonusNumber) {
        if (isNumberOutOfRange(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
        }
    }

    private boolean isNumberOutOfRange(int n) {
        return n < LOTTO_MIN_NUM_INTENSION || n > LOTTO_MAX_NUM_INTENSION;
    }

    public int 우승자들 () {
        return 0;
    }
}
