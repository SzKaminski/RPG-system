package com.szkaminski.RPG.characters.Items;

import java.util.ArrayList;

public class Equipment<Item> extends ArrayList<Item> {

    public Equipment() {
    }

 /*   public boolean add(Item item, Character character) {
        int eqSize;
        if (character.getStrength() != null) {
            eqSize = character.getStrength().getValue() / 2;
        } else
            eqSize = 3;
        if (this.size() < eqSize) {
            return super.add(item);
        }
        System.out.println("Your cannot have more than " + eqSize + " items");

        return false;
    }*/
}
