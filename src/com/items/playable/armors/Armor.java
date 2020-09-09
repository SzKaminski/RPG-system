package com.items.playable.armors;

import com.items.Item;
import com.items.ItemCondition;
import com.items.ItemType;

public class Armor extends Item {

    private double blockChance;
    private int blockValue;

    public Armor() {
    }

    public Armor(String name, int value, ItemCondition condition) {
        super(name, ItemType.ARMOR, value, condition);
    }
}
