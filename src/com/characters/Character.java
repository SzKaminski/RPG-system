package com.characters;

import com.characters.characterAttributes.*;
import com.items.Item;

import java.util.List;

public abstract class Character {

    private int level = 1;

    private CharAttribute charAttribute;

    private Strenght strenght;
    private Dexterity dexterity;
    private Endurance endurance;
    private Intelligence intelligence;

    private MeleeAttack meleeAttack;
    private Dodge dodge;
    private HealthPoints healthPoints;
    private ManaPoints manaPoints;


    private List<Item> items;

    public Character() {
    }

    //todo: Have to figure out what to do with special attributes (hp, mp, meleeAttack, dodge)

    public Character(HealthPoints healthPoints,
                     Endurance endurance,
                     Intelligence intelligence,
                     ManaPoints manaPoints,
                     Strenght strenght,
                     MeleeAttack meleeAttack,
                     Dexterity dexterity,
                     Dodge dodge) {
        this.healthPoints = healthPoints;
        this.endurance = endurance;
        this.intelligence = intelligence;
        this.manaPoints = manaPoints;
        this.strenght = strenght;
        this.meleeAttack = meleeAttack;
        this.dexterity = dexterity;
        this.dodge = dodge;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }


    /*public void setMeleeAttack(int meleeAttack) {
        this.meleeAttack = this.strenght * 10 / 20;
    }*/

    public HealthPoints getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(HealthPoints healthPoints) {
        this.healthPoints = healthPoints;
    }

    public Endurance getEndurance() {
        return endurance;
    }

    public void setEndurance(Endurance endurance) {
        this.endurance = endurance;
    }

    public Intelligence getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(Intelligence intelligence) {
        this.intelligence = intelligence;
    }

    public ManaPoints getManaPoints() {
        return manaPoints;
    }

    public void setManaPoints(ManaPoints manaPoints) {
        this.manaPoints = manaPoints;
    }

    public Strenght getStrenght() {
        return strenght;
    }

    public void setStrenght(Strenght strenght) {
        this.strenght = strenght;
    }

    public MeleeAttack getMeleeAttack() {
        return meleeAttack;
    }

    public void setMeleeAttack(MeleeAttack meleeAttack) {
        this.meleeAttack = meleeAttack;
    }

    public Dexterity getDexterity() {
        return dexterity;
    }

    public void setDexterity(Dexterity dexterity) {
        this.dexterity = dexterity;
    }

    public Dodge getDodge() {
        return dodge;
    }

    public void setDodge(Dodge dodge) {
        this.dodge = dodge;
    }

    public CharAttribute getAttribute() {
        return charAttribute;
    }
}
