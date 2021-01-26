package com.lld.questions.vendingmachine;

public enum Cash {

    PENNY(1), NICKEL(5), DIME(10), QUARTER(25);

    private int value;

    Cash(int value) {
        this.value = value;
    }

    public int getCashValue() {
        return value;
    }
}
