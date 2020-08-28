package com.characters.characterAttributes;

public class MeleeAttack extends CharAttribute implements ComputingAttribute {

    public MeleeAttack() {
        super("Melee Attack", "AP");
    }

    @Override
    public int computeValue(int attribute) {
        return attribute * 10 / 20;
    }
}
