package com.classes;

public class Warrior extends CharacterClass {

    public Warrior() {
        createBasicClass();
    }

    @Override
    public void createBasicClass() {
        setName("Warrior");
        setType(Type.PHYSIC);
        setHealthPoints(50);
        setEndurance(10);
        setManaPoints(0);
        setIntelligence(10);
        setStrenght(15);
        setDexterity(5);
    }
}
