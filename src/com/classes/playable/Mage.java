package com.classes.playable;

import com.characters.characterAttributes.*;
import com.classes.CharacterClass;
import com.classes.Type;

public class Mage extends CharacterClass {

    public Mage() {
        super(new Strenght(5),
                new Dexterity(5),
                new Endurance(5),
                new Intelligence(20));

        setName("Mage");
        setType(Type.MAGIC);
    }
}
