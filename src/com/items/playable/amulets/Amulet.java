package com.items.playable.amulets;

import com.characters.Character;
import com.characters.characterAttributes.CharAttribute;
import com.characters.characterAttributes.HealthPoints;
import com.items.Item;
import com.items.ItemCondition;
import com.items.ItemType;
import com.visualeffects.Printer;

public class Amulet extends Item {

    private int charAttribute;

    public Amulet() {
    }

    public Amulet(String name, int value) {
        super(name, ItemType.AMULET, value);
    }

    public Amulet(String name, int value, int charAttribute) {
        super(name, ItemType.AMULET, value);
        this.charAttribute = charAttribute;
    }

    public void increaseAttribute(Character character) {
    }

    public int getCharAttribute() {
        return charAttribute;
    }
}