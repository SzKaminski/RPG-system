package com.items;

import com.characters.Character;

import java.util.ArrayList;

public class Equipment<Item> extends ArrayList<Item> {

    public Equipment() {
    }

    public boolean add(Item item, Character character) {
        int eqSize = character.getStrength().getValue() / 2;
        if (this.size() < eqSize) {
            return super.add(item);
        }
        System.out.println("Your cannot have more than " + eqSize + " items");

        return false;
    }
}
