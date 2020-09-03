package com.characters.characterAttributes;

public class HealthPoints extends CharAttribute implements ComputingAttribute {

    private int actualValue;

    public HealthPoints(int value) {
        super("Health Points", "HP", value);
        this.actualValue = value;
    }

    public HealthPoints() {
        super("Health Points", "HP");
    }

    @Override
    public int computeValue(int attribute) {
        return attribute * 5;
    }

    public int getActualValue() {
        return actualValue;
    }

    public void setActualValue(int actualValue) {
        this.actualValue = actualValue;
    }
}
