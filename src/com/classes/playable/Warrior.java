package com.classes.playable;

import com.characters.characterAttributes.*;
import com.classes.CharacterClass;
import com.classes.Type;

public class Warrior extends CharacterClass {

    public Warrior() {
        super(new HealthPoints(50),
                new Endurance(10),
                new Intelligence(10),
                new ManaPoints(0),
                new Strenght(15),
                new MeleeAttack(5),
                new Dexterity(5),
                new Dodge(5));

        setName("Warrior");
        setType(Type.PHYSIC);
    }
}
