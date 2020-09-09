package com.items.playable.armors;

import com.characters.characterAttributes.Strength;
import com.items.ItemCondition;


public class PeasantShirt extends Armor {

    public PeasantShirt() {
        super("Peasant Shirt",
                1,
                new ItemCondition(new Strength(), 1),
                1);
    }
}
