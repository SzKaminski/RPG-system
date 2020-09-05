package com.items.playable;

import com.characters.characterAttributes.Strength;
import com.items.Armor;
import com.items.ItemCondition;


public class PeasantShirt extends Armor {

    public PeasantShirt() {
        super("Peasant Shirt",
                1,
                new ItemCondition(new Strength(), 1));
    }
}
