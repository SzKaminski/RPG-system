package com.classes.playable;

import com.characters.characterAttributes.*;
import com.classes.CharacterClass;
import com.classes.Type;

public class Mage extends CharacterClass {

    public Mage() {
        super(new HealthPoints(20),
                new Endurance(5),
                new Intelligence(20),
                new ManaPoints(50),
                new Strenght(5),
                new MeleeAttack(5),
                new Dexterity(5),
                new Dodge(5)
        );

        setName("Mage");
        setType(Type.MAGIC);
    }
}
