package com.lld.questions.vendingmachine.states;

import com.lld.questions.vendingmachine.Cash;

public abstract class VendingMachineState {
    
    private String state;

    public VendingMachineState(String state) {
        this.state = state;
    }

    public void insertCash(Cash cash) {
        throw new RuntimeException("Vending machine is in " +  state + "., hence unable to add the cash");
    }

    public void selectItem(int itemCode) {
        throw new RuntimeException("Vending machine is in " +  state + "., hence unable to select a product");
    }

    public void processRequest() {
        throw new RuntimeException("Vending machine is in " + state + "., hence unable to process request");
    }

    public void dispenseItemAndCash() {
        throw new RuntimeException("Vending machine is in " + state + "., hence unable to dispense");
    }

    public void cancelRequest() {
        throw new RuntimeException("Vending machine is in " + state + "., hence unable to cancel the current request");
    }
}
