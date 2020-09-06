package com.items.playable.consumables;

import com.items.Item;
import com.items.ItemType;

public class Consumable extends Item {

    public Consumable() {
    }

    public Consumable(String name, int value) {
        super(name, ItemType.AMULET, value);
    }
}
