package com.characters.characterAttributes;

public class ManaPoints extends CharAttribute implements ComputingAttribute {

    public ManaPoints() {
        super("Mana Points", "MP");
    }

    @Override
    public int computeValue(int attribute) {
        return attribute * 5;
    }
}
