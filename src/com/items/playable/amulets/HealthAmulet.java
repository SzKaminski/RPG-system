package com.items.playable.amulets;

import com.characters.Character;

public class HealthAmulet extends Amulet {

    public HealthAmulet() {
        super("Amulet of Health", 50, 20);
    }

    @Override
    public void increaseAttribute(Character character) {
        if (isEquipped()){
            character.addHealthPoints(this.getCharAttribute());
        }else
            character.setBasicHealthPoints();
    }

}
