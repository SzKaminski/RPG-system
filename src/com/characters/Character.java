package com.characters;

public abstract class Character {

    private int healthPoints;
    private int endurance;
    private int manaPoints;
    private int intelligence;
    private int meleeAttack;
    private int strenght;
    private int dodge;
    private int dexterity;

    public Character(int healthPoints, int endurance, int manaPoints, int intelligence, int meleeAttack, int strenght, int dodge, int dexterity) {
        this.healthPoints = healthPoints;
        this.endurance = endurance;
        this.manaPoints = manaPoints;
        this.intelligence = intelligence;
        this.meleeAttack = meleeAttack;
        this.strenght = strenght;
        this.dodge = dodge;
        this.dexterity = dexterity;
    }

    public Character() {
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getEndurance() {
        return endurance;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    public int getManaPoints() {
        return manaPoints;
    }

    public void setManaPoints(int manaPoints) {
        this.manaPoints = manaPoints;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getMeleeAttack() {
        return meleeAttack;
    }

    public void setMeleeAttack(int meleeAttack) {
        this.meleeAttack = this.strenght * 10 / 20;
    }

    public int getStrenght() {
        return strenght;
    }

    public void setStrenght(int strenght) {
        this.strenght = strenght;
    }

    public int getDodge() {
        return dodge;
    }

    public void setDodge(int dodge) {
        this.dodge = this.dexterity * 10 / 20;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }
}
