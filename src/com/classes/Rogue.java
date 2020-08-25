package com.classes;

public class Rogue extends CharacterClass {

    public Rogue() {
        createBasicClass();
    }

    @Override
    public void createBasicClass() {
        setName("Rogue");
        setType(Type.PHYSIC);
        setHealthPoints(30);
        setEndurance(5);
        setManaPoints(5);
        setIntelligence(15);
        setStrenght(10);
        setDexterity(50);
    }
}
