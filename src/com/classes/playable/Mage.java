package com.classes.playable;

import com.classes.CharacterClass;
import com.classes.Type;

public class Mage extends CharacterClass {

    public Mage() {
        createBasicClass();
    }

    @Override
    public void createBasicClass() {
        setName("Mage");
        setType(Type.MAGIC);
        setHealthPoints(20);
        setEndurance(5);
        setManaPoints(50);
        setIntelligence(20);
        setStrenght(5);
        setDexterity(5);
    }

}
