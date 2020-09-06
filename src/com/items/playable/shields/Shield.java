package com.items.playable.shields;

import com.items.Item;
import com.items.ItemType;

public class Shield extends Item {

    public Shield() {
    }

    public Shield(String name, int value) {
        super(name, ItemType.SHIELD, value);
    }
}
