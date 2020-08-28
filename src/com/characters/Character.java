package com.characters;

import com.characters.characterAttributes.*;
import com.items.Item;

import java.util.ArrayList;
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
        items = new ArrayList<>(3);
    }

    //todo: Have to figure out what to do with special attributes (hp, mp, meleeAttack, dodge)

    public Character(Strenght strenght,
                     Dexterity dexterity,
                     Endurance endurance,
                     Intelligence intelligence) {
        this.strenght = strenght;
        this.dexterity = dexterity;
        this.endurance = endurance;
        this.intelligence = intelligence;

    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public HealthPoints getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(Endurance endurance) {
        this.healthPoints = new HealthPoints();
        int i = healthPoints.computeValue(endurance.getValue());
        healthPoints.setValue(i);
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

    public void setManaPoints(Intelligence intelligence) {
        this.manaPoints = new ManaPoints();
        int i = manaPoints.computeValue(intelligence.getValue());
        manaPoints.setValue(i);
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

    public void setMeleeAttack(Strenght strenght) {
        this.meleeAttack = new MeleeAttack();
        int i = meleeAttack.computeValue(strenght.getValue());
        meleeAttack.setValue(i);
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

    public void setDodge(Dexterity dexterity) {
        this.dodge = new Dodge();
        int i = dodge.computeValue(dexterity.getValue());
        dodge.setValue(i);
    }

    public CharAttribute getAttribute() {
        return charAttribute;
    }

}
