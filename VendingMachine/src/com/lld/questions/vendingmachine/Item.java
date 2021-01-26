package com.lld.questions.vendingmachine;

public enum Item {
    COKE("Coke", 25), CHOCOLATE("Chocolate", 20), CAKE("Cake", 10);
    private String name;
    private int price;

    Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
