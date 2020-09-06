package com.items.playable.weapons;

import com.characters.characterAttributes.Strength;
import com.items.ItemCondition;

public class Branch extends Weapon {

    public Branch() {
        super("Branch",
                0,
                new ItemCondition(new Strength(), 5),
                1,
                1,
                0.01);
    }
}
