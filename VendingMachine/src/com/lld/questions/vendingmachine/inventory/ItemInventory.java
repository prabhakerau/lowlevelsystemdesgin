package com.lld.questions.vendingmachine.inventory;

import com.lld.questions.vendingmachine.Item;

import java.util.HashMap;
import java.util.Map;

public class ItemInventory {

    private Map<Item, Integer> items = new HashMap<>();

    public void addItem(Item item) {
        items.put(item, items.getOrDefault(item, 0) + 1);
    }

    public void deductItem(Item item) {
        Integer existingItem = items.get(item);
        if(existingItem != null) {
            items.put(item, items.get(item) - 1);
            if(items.get(item) == 0) {
                items.remove(item);
            }
        }
    }

    public boolean isItemAvailable(Item item) {
        return items.get(item) != null;
    }

}
