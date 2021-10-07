package com.lld.questions.vendingmachine.inventory;

import com.lld.questions.vendingmachine.Cash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CashInventory {

    private Map<Cash, Integer> cash = new HashMap<>();

    public void addCash(Cash cash) {
        this.cash.put(cash, this.cash.getOrDefault(cash, 0) + 1);
    }

    public void deductCash(Cash cash) {
        Integer existingCash = this.cash.get(cash);
        if( existingCash != null) {
            this.cash.put(cash, this.cash.get(cash) - 1);
            if(this.cash.get(cash) == 0) {
                this.cash.remove(cash);
            }
        }
    }

    public List<Cash> getChange(int remainingBalance) {
        List<Cash> change = new ArrayList<>();
        int balance = remainingBalance;
        int quarterAmount = cash.getOrDefault(Cash.QUARTER,0);
        int dimeAmount = cash.getOrDefault(Cash.DIME,0);
        int nickelAmount = cash.getOrDefault(Cash.NICKEL,0);
        int pennyAmount = cash.getOrDefault(Cash.PENNY,0);

        while(balance > 0) {
            if(balance >= Cash.QUARTER.getCashValue() && quarterAmount > 0){
                quarterAmount--;
                change.add(Cash.QUARTER);
                balance = balance - Cash.QUARTER.getCashValue();
            } else if(balance >= Cash.DIME.getCashValue() && dimeAmount > 0) {
                dimeAmount--;
                change.add(Cash.DIME);
                balance = balance - Cash.DIME.getCashValue();
            } else if(balance >= Cash.NICKEL.getCashValue() && nickelAmount > 0) {
                nickelAmount--;
                change.add(Cash.NICKEL);
                balance = balance - Cash.NICKEL.getCashValue();
            } else if(balance >= Cash.PENNY.getCashValue() && pennyAmount > 0) {
                pennyAmount--;
                change.add(Cash.PENNY);
                balance = balance - Cash.PENNY.getCashValue();
            } else {
                return null;
            }
        }
        return change;
    }
}
