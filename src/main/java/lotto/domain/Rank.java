package lotto.domain;

public enum Rank {
    // TODO: 이등을 제외하고는 false여도 조건 만족
    일등(1, 6, false,2000000000, "6개 일치 (2,000,000,000원)"),
    이등(2, 5, true,30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    삼등(3, 5, false,1500000, "5개 일치 (1,500,000원)"),
    사등(4, 4, false,50000, "4개 일치 (50,000원)"),
    오등(5, 3, false,5000, "3개 일치 (5,000원)"),
    ;

    private final int rank;
    private final int correctNumber;
    private final boolean isBonusNumCorrect;
    private final int winningMoney;
    private final String winningMessage;

    Rank(int rank, int correctNumber, boolean isBonusNumCorrect, int winningMoney, String winningMessage) {
        this.rank = rank;
        this.correctNumber = correctNumber;
        this.isBonusNumCorrect = isBonusNumCorrect;
        this.winningMoney = winningMoney;
        this.winningMessage = winningMessage;
    }

    public int getRank() {
        return rank;
    }

    public int getCorrectNumber() {
        return correctNumber;
    }

    public boolean isBonusNumCorrect() {
        return this.isBonusNumCorrect;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public String getWinningMessage() {
        return winningMessage;
    }
}
