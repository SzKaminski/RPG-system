package com.characters.npcs;

import com.characters.Character;
import com.characters.characterAttributes.Dexterity;
import com.characters.characterAttributes.Endurance;
import com.characters.characterAttributes.Intelligence;
import com.characters.characterAttributes.Strength;
import com.items.playable.ammunition.Arrows;
import com.items.playable.amulets.HealthAmulet;
import com.items.playable.armors.PeasantShirt;
import com.items.playable.consumables.Cheese;
import com.items.playable.shields.OldWoodenShield;
import com.items.playable.weapons.Branch;
import com.items.playable.weapons.RustySword;
import com.places.MarketPlace;

public class Merchant extends Character {


    public Merchant() {
        super(new Strength(100), new Dexterity(10), new Endurance(10), new Intelligence(10));
        setGold(5000);
        setLocation(new MarketPlace());
        setName("Nate Ganray");
        setDescription("placeholder description");
        getItems().add(new Branch());
        getItems().add(new RustySword());
        getItems().add(new PeasantShirt());
        getItems().add(new Arrows());
        getItems().add(new HealthAmulet());
        getItems().add(new Cheese());
        getItems().add(new OldWoodenShield());
    }

    @Override
    public void getConversation() {
        System.out.println("You are approaching " + this.getName());
    }

}
