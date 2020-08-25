package com.classes;

import com.characters.Character;

public abstract class CharacterClass extends Character {

    private String name;
    private Type type;

    public abstract void createBasicClass();

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
