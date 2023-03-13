package domain.money;

public class BettingMoney extends Money {
    private static final int MAX_SIZE = 10_000_000;
    private static final int MIN_SIZE = -10_000_000;

    private BettingMoney(final int value){
        super(value);
    }

    public static BettingMoney of(final int value){
        validateSize(value);
        return new BettingMoney(value);
    }

    public static void validateSize(final int value) {
        if (value > MAX_SIZE || value < MIN_SIZE) {
            throw new IllegalArgumentException(String.format("돈은 %s이하, %이상만 입력할 수 있습니다.", MAX_SIZE, MIN_SIZE));
        }
    }
}
