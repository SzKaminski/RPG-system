package com.characters.characterAttributes;

public class HealthPoints extends CharAttribute implements ComputingAttribute {

    public HealthPoints(int value) {
        super("Health Points", "HP", value);
    }

    public HealthPoints() {
        super("Health Points", "HP");
    }

    @Override
    public int computeValue(int attribute) {
        return attribute * 5;
    }
}
