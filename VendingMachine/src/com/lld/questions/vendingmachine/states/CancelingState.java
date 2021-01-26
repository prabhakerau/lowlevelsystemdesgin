package com.lld.questions.vendingmachine.states;

import com.lld.questions.vendingmachine.VendingMachine;

public class CancelingState extends VendingMachineState {

    private VendingMachine vendingMachine;

    public CancelingState(VendingMachine vendingMachine) {
        super("Cancel request");
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void cancelRequest() {
        int remainingBalance = vendingMachine.getEnteredCashValue();
        vendingMachine.restSelectedItem();
        vendingMachine.resetEnteredCashValue();
        System.out.println("Request canceled successfully");
        vendingMachine.setState(new DispensingState(vendingMachine, vendingMachine.getChange(remainingBalance)));
        vendingMachine.dispenseItemAndCash();

    }
}
