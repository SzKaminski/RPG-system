package com.items;

import com.characters.characterAttributes.CharAttribute;

public class ItemCondition {

    private CharAttribute attribute;
    private int value;


    public ItemCondition(CharAttribute attribute, int value) {
        this.attribute = attribute;
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
