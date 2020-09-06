package com.items.playable.ammunition;

import com.items.Item;
import com.items.ItemType;

public class Ammunition extends Item {

    public Ammunition() {
    }

    public Ammunition(String name, int value) {
        super(name, ItemType.AMMUNITION, value);
    }
}
