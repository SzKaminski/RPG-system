package com.characters.characterAttributes;

public interface ComputingAttribute {

    static int computeHealthPoints(int attribute) {
        return attribute * 5;
    }

    static int computeManaPoints(int attribute) {
        return attribute * 5;
    }

    static int computeMeleeAttack(int attribute) {
        return attribute * 10 / 20;
    }

    static int computeDodge(int attribute) {
        return attribute * 10 / 20;
    }

}
