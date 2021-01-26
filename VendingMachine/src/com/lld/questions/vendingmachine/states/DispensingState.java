package com.lld.questions.vendingmachine.states;

import com.lld.questions.vendingmachine.Cash;
import com.lld.questions.vendingmachine.VendingMachine;

import java.util.List;

public class DispensingState extends VendingMachineState {

    private VendingMachine vendingMachine;
    private List<Cash> change;

    public DispensingState(VendingMachine vendingMachine, List<Cash> change) {
        super("Dispensing state");
        this.vendingMachine = vendingMachine;
        this.change = change;
    }

    @Override
    public void dispenseItemAndCash() {

        if(vendingMachine.getSelectedItem() != null) {
            System.out.println("Dispensed item is : "+ vendingMachine.getSelectedItem().getName());
        }

        if(change != null) {
            for(Cash cash : change) {
                vendingMachine.deductCash(cash);
                System.out.println("Dispensed cash is : "+ cash.getCashValue());
            }
        }

        vendingMachine.setState(new ReadyState(vendingMachine));
    }
}
