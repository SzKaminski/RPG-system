package com.items;

public class Armor extends Item {

    public Armor() {
    }

    public Armor(String name, int value, ItemCondition condition) {
        super(name, ItemType.ARMOR, value, condition);
    }
}
