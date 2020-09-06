package com.items.playable.weapons;

import com.characters.characterAttributes.Strength;
import com.items.ItemCondition;

public class RustySword extends Weapon {

    public RustySword() {
        super("Rusty Sword",
                1,
                new ItemCondition(new Strength(), 10),
                2,
                1,
                0.01);
    }
}
