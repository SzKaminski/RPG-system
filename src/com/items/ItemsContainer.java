package com.items;

import com.items.playable.Branch;
import com.items.playable.RustySword;

import java.util.ArrayList;
import java.util.List;

public class ItemsContainer {

    //todo: need to find some fancy solution for this
    private List<Item> items;

    public ItemsContainer() {
        this.items = new ArrayList<>();
        items.add(new Branch());
        items.add(new RustySword());
    }

    public List<Item> getItems() {
        return items;
    }
}
