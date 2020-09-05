package com.items;

import com.characters.Character;
import com.items.playable.Branch;
import com.items.playable.PeasantShirt;
import com.items.playable.RustySword;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ItemsContainer {

    //todo: need to find some fancy solution for this
    private List<Item> items;
    private Random r;

    public ItemsContainer() {
        this.items = new ArrayList<>();
        items.add(new Branch());
        items.add(new RustySword());
        items.add(new PeasantShirt());
        r = new Random();
    }

    public List<Item> getItems() {
        return items;
    }

    public Item getRandomItem() {
        int size = items.size();
        if (size > 0)
            return getItems().get(r.nextInt(size));
        else
            return null;
    }
}
