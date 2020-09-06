package com.items.playable.amulets;

import com.items.Item;
import com.items.ItemType;

public class Amulet extends Item {

    public Amulet() {
    }

    public Amulet(String name, int value) {
        super(name, ItemType.AMULET, value);
    }
}
