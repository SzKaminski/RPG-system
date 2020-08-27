package com.items;

public class Weapon extends Item {

    public Weapon(String name, int value, ItemCondition condition) {
        super(name, ItemType.WEAPON, value, condition);
    }
}
