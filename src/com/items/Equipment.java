package com.items;

import java.util.ArrayList;

public class Equipment<Item> extends ArrayList<Item> {

    private final int MAXSIZE = 3;

    public Equipment() {
    }

    @Override
    public boolean add(Item item) {
        if (this.size() < MAXSIZE) {
            return super.add(item);
        }
        return false;
    }
}
