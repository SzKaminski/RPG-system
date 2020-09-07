package com.classes.playable;

import com.characters.characterAttributes.*;
import com.classes.CharacterClass;
import com.classes.Type;

public class Warrior extends CharacterClass {

    public Warrior() {
        super(new Strength(15),
                new Dexterity(5),
                new Endurance(10),
                new Intelligence(10));

        setName("Warrior");
        setType(Type.PHYSIC);
    }

}
