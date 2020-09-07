package com.classes.playable;

import com.characters.characterAttributes.*;
import com.classes.CharacterClass;
import com.classes.Type;

public class Rogue extends CharacterClass {

    public Rogue() {
        super(new Strength(10),
                new Dexterity(50),
                new Endurance(5),
                new Intelligence(15));


        setName("Rogue");
        setType(Type.PHYSIC);
    }
}
