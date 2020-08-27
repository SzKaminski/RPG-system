package com.classes.playable;

import com.characters.characterAttributes.*;
import com.classes.CharacterClass;
import com.classes.Type;

public class Rogue extends CharacterClass {

    public Rogue() {
        super(new HealthPoints(30),
                new Endurance(5),
                new Intelligence(15),
                new ManaPoints(5),
                new Strenght(10),
                new MeleeAttack(5),
                new Dexterity(50),
                new Dodge(5));

        setName("Rogue");
        setType(Type.PHYSIC);
    }
}
