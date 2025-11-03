package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.ErrorMessage;

public class Lotto {

    private final static int LOTTO_MIN_NUM_INTENSION = 1;
    private final static int LOTTO_MAX_NUM_INTENSION = 45;
    private final static int LOTTO_WINNING_NUM = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateNumber(numbers);
        validateDuplicateNumber(numbers);
        this.numbers = numbers;
    }

    // TODO: 메소드명
    public static Lotto createRandomLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUM_INTENSION, LOTTO_MAX_NUM_INTENSION,
                LOTTO_WINNING_NUM);
        List<Integer> mutableNumbers = new ArrayList<>(numbers);
        Collections.sort(mutableNumbers); // 변경 불가능한 컬렉션 정렬
        return new Lotto(mutableNumbers);
    }

    public boolean isContainNum(int n) {
        return numbers.contains(n);
    }

    List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_WINNING_NUM) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_WINNING_NUMBER_OUT_OF_RANDE.getMessage());
        }
    }

    private void validateNumber(List<Integer> numbers) {
        for (int n : numbers) {
            if (isNumOutOfRange(n)) {
                throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
            }
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        Set<Integer> distinctNumbers = new HashSet<>(numbers);
        if (distinctNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_DUPLICATED.getMessage());
        }
    }

    private boolean isNumOutOfRange(int n) {
        return n < LOTTO_MIN_NUM_INTENSION || n > LOTTO_MAX_NUM_INTENSION;
    }

    public String toString() {
        return numbers.toString();
    }
}
