package com.items;

import java.util.Random;

public class Weapon extends Item {

    private int baseAttack;
    private int fluctuatesPoints;
    private double critChancePercentage;

    private Random r;

    public Weapon(String name, int value, ItemCondition condition) {
        super(name, ItemType.WEAPON, value, condition);
    }

    public Weapon(String name, int value, ItemCondition condition, int baseAttack, int fluctuatesPoints, double critChances) {
        super(name, ItemType.WEAPON, value, condition);
        r = new Random();
        setBaseAttack(baseAttack);
        this.fluctuatesPoints = fluctuatesPoints;
        this.critChancePercentage = critChances;
    }

    public void setBaseAttack(int baseAttack) {
        int i = getFluctuationState();
        if (i > 0) {
            this.baseAttack = baseAttack + fluctuatesPoints;
        } else if (i == 0) {
            this.baseAttack = baseAttack;
        } else
            this.baseAttack = baseAttack - fluctuatesPoints;
    }

    public int getFluctuationState() {
        return r.nextInt(3) - 1;
    }

    public boolean isCritical(double critChances) {
        return r.nextDouble() > 1.0 - critChances;
    }
}
