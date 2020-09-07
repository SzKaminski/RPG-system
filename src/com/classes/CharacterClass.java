package com.classes;

import com.characters.Character;
import com.characters.characterAttributes.*;


public abstract class CharacterClass extends Character {

    private String name;
    private Type type;

    public CharacterClass() {
    }

    public CharacterClass(Strength strength, Dexterity dexterity, Endurance endurance, Intelligence intelligence) {
        super(strength, dexterity, endurance, intelligence);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

}
