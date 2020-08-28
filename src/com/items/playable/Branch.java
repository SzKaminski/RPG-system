package com.items.playable;

import com.characters.characterAttributes.Strenght;
import com.items.ItemCondition;
import com.items.Weapon;

public class Branch extends Weapon {

    public Branch() {
        super("Branch",
                0,
                new ItemCondition(new Strenght(), 5),
                1,
                1,
                0.01);
    }


}
