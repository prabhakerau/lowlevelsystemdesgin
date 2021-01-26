package com.lld.questions.vendingmachine;


public class Main {

    public static void main(String[] args) {

	    VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.addItem(Item.CHOCOLATE);
        vendingMachine.addItem(Item.COKE);
        vendingMachine.addItem(Item.CAKE);




        vendingMachine.insertCash(Cash.NICKEL);
        vendingMachine.insertCash(Cash.QUARTER);
        vendingMachine.selectItem(2);
        vendingMachine.cancelRequest();
        //vendingMachine.processRequest();
    }
}
