package com.items;

import com.items.playable.ammunition.Arrows;
import com.items.playable.amulets.HealthAmulet;
import com.items.playable.consumables.Cheese;
import com.items.playable.shields.OldWoodenShield;
import com.items.playable.weapons.Branch;
import com.items.playable.armors.PeasantShirt;
import com.items.playable.weapons.RustySword;

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
        items.add(new Arrows());
        items.add(new HealthAmulet());
        items.add(new Cheese());
        items.add(new OldWoodenShield());
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

    public int getRandomNumber(){
        return r.nextInt(20);
    }
}
