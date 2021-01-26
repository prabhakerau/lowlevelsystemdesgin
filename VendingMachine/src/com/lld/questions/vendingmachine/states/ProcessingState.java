package com.lld.questions.vendingmachine.states;

import com.lld.questions.vendingmachine.VendingMachine;
import com.lld.questions.vendingmachine.exceptions.ChangeNotAvailableException;
import com.lld.questions.vendingmachine.exceptions.InSufficientCashException;
import com.lld.questions.vendingmachine.exceptions.ItemNotAvailableException;
import com.lld.questions.vendingmachine.exceptions.ItemNotSelectedException;

public class ProcessingState extends VendingMachineState {

    private VendingMachine vendingMachine;

    public ProcessingState(VendingMachine vendingMachine) {
        super("Processing state");
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void processRequest() {

        if(vendingMachine.getSelectedItem() == null) {
            throw new ItemNotSelectedException("Item not is not selected to process the request");
        }
        if(!vendingMachine.isSelectedItemAvailable()) {
            throw new ItemNotAvailableException("The requested item not available");
        }
        if(!vendingMachine.isSufficientCashInserted()) {
            throw new InSufficientCashException("Entered cash is not sufficient to get the item");
        }
        if(!vendingMachine.isChangeAvailableForEnteredCash()) {
            throw new ChangeNotAvailableException("Change not available");
        }

        vendingMachine.deductItem(vendingMachine.getSelectedItem());
        int remainingBalance = vendingMachine.getEnteredCashValue() - vendingMachine.getSelectedItem().getPrice();
        vendingMachine.setState(new DispensingState(vendingMachine, vendingMachine.getChange(remainingBalance)));
        vendingMachine.dispenseItemAndCash();
    }
}
