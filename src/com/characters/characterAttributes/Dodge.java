package com.characters.characterAttributes;

public class Dodge extends CharAttribute implements ComputingAttribute {

    public Dodge() {
        super("Dodge", "Dod");
    }

    @Override
    public int computeValue(int attribute) {
        return attribute * 10 / 20;
    }
}
