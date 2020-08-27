package com.items.playable;

import com.characters.characterAttributes.Strenght;
import com.items.ItemCondition;
import com.items.Weapon;

public class RustySword extends Weapon {

    public RustySword() {
        super("Rusty Sword", 1, new ItemCondition(new Strenght(), 10));
    }
}
