package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.ErrorMessage;

public class Lotto {

    private final static int LOTTO_MIN_NUM_INTENSION = 1;
    private final static int LOTTO_MAX_NUM_INTENSION = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateNumber(numbers);
        validateDuplicateNumber(numbers);
        this.numbers = numbers;
    }

    // TODO: 메소드명
    public static Lotto createRandomLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
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
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateNumber(List<Integer> numbers) {
        // TODO: depth = 2
        for (int n : numbers) {
            if (isNumOutOfRange(n)) {
                throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
            }
        }
    }

    // TODO: 위와 합치면 for문 한번만 가능
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
