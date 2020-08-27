package com.classes;

import com.characters.Character;
import com.characters.characterAttributes.*;


public abstract class CharacterClass extends Character {

    private String name;
    private Type type;

    public CharacterClass(HealthPoints healthPoints,
                          Endurance endurance,
                          Intelligence intelligence,
                          ManaPoints manaPoints,
                          Strenght strenght,
                          MeleeAttack meleeAttack,
                          Dexterity dexterity,
                          Dodge dodge) {
        super(healthPoints, endurance, intelligence, manaPoints, strenght, meleeAttack, dexterity, dodge);
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
