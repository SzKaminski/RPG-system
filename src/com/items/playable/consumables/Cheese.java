package com.items.playable.consumables;

import com.characters.Character;
import com.characters.characterAttributes.HealthPoints;

public class Cheese extends Consumable {

    public Cheese() {
        super("Cheese", 50);
    }

    @Override
    public void consume(Character character) {
        int i = character.getActualHealthPoints().getValue() + 15;
        character.setActualHealthPoints(new HealthPoints(i));
        super.consume(character);
    }
}
