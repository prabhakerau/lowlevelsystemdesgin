package com.lld.questions.vendingmachine;

import com.lld.questions.vendingmachine.inventory.CashInventory;
import com.lld.questions.vendingmachine.inventory.ItemInventory;
import com.lld.questions.vendingmachine.states.ReadyState;
import com.lld.questions.vendingmachine.states.VendingMachineState;

import java.util.List;

public class VendingMachine {

    private Item selectedItem = null;
    private int enteredCashValue = 0;

    private VendingMachineState vendingMachineState = new ReadyState(this);
    private ItemInventory itemInventory = new ItemInventory();
    private CashInventory cashInventory = new CashInventory();


    public VendingMachine() {

    }

    public void addCash(Cash cash) {
        enteredCashValue += cash.getCashValue();
        cashInventory.addCash(cash);
    }

    public void deductCash(Cash cash) {
        cashInventory.deductCash(cash);
    }

    public void addItem(Item item) {
       itemInventory.addItem(item);
    }

    public void deductItem(Item item) {
        itemInventory.deductItem(item);
    }

    public int getEnteredCashValue() {
        return this.enteredCashValue;
    }

    public void resetEnteredCashValue() {
        this.enteredCashValue = 0;
    }

    public Item getSelectedItem() {
        return this.selectedItem;
    }

    public void setSelectedItem(Item selectedItem) {
        this.selectedItem = selectedItem;
    }

    public void restSelectedItem() {
        this.selectedItem = null;
    }

    public boolean isSelectedItemAvailable() {
        return itemInventory.isItemAvailable(selectedItem);
    }

    public boolean isChangeAvailableForEnteredCash() {
        int remainingBalance = enteredCashValue - selectedItem.getPrice();
        if(remainingBalance != 0) {
            List<Cash> change = cashInventory.getChange(remainingBalance);
            return change != null ? true : false;
        }
        return true;
    }

    public boolean isSufficientCashInserted() {
        return enteredCashValue >= selectedItem.getPrice();
    }

    public List<Cash> getChange(int remainingBalance) {
        return cashInventory.getChange(remainingBalance);
    }

    public void setState(VendingMachineState state) {
        this.vendingMachineState = state;
    }


    //vending machine state related methods starts here

    public void insertCash(Cash cash) {
        vendingMachineState.insertCash(cash);
    }
    public void selectItem(int itemCode) {
        vendingMachineState.selectItem(itemCode);
    }

    public void processRequest() {
        vendingMachineState.processRequest();
    }

    public void dispenseItemAndCash() {
        vendingMachineState.dispenseItemAndCash();
    }

    public void cancelRequest() {
        vendingMachineState.cancelRequest();
    }

}
