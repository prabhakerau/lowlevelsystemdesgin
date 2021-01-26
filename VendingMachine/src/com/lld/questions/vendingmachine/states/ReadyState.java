package com.lld.questions.vendingmachine.states;

import com.lld.questions.vendingmachine.Cash;
import com.lld.questions.vendingmachine.Item;
import com.lld.questions.vendingmachine.VendingMachine;

public class ReadyState  extends VendingMachineState {

    private VendingMachine vendingMachine;

    public ReadyState(VendingMachine vendingMachine) {
        super("Ready state");
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCash(Cash cash) {
        vendingMachine.addCash(cash);
    }

    @Override
    public void selectItem(int itemCode) {
        vendingMachine.setSelectedItem(getItemFromItemCode(itemCode));
    }

    @Override
    public void processRequest() {
        vendingMachine.setState(new ProcessingState(vendingMachine));
        vendingMachine.processRequest();
    }

    @Override
    public void cancelRequest() {
        vendingMachine.setState(new CancelingState(vendingMachine));
        vendingMachine.cancelRequest();
    }

    public Item getItemFromItemCode(int itemCode) {
        if(itemCode == 1) {
            return Item.CHOCOLATE;
        } else if(itemCode == 2) {
            return  Item.COKE;
        } else if (itemCode == 3) {
            return  Item.CAKE;
        }
        return null;
    }
}
