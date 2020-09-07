package com.items.playable.consumables;

import com.characters.Character;
import com.items.Item;
import com.items.ItemType;

public class Consumable extends Item {

    public Consumable() {
    }

    public Consumable(String name, int value) {
        super(name, ItemType.CONSUMABLE, value);
    }

    public void consume(Character character){
        System.out.println(this.getName() + " consumed");
    }
}
