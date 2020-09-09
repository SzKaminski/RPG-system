package com.items.playable.armors;

import com.characters.Character;
import com.items.Item;
import com.items.ItemCondition;
import com.items.ItemType;
import com.visualeffects.Printer;

public class Armor extends Item {

    private int armorValue;

    public Armor() {
    }

    public Armor(String name, int value, ItemCondition condition, int armorValue) {
        super(name, ItemType.ARMOR, value, condition);
        this.armorValue = armorValue;
    }

    public int reduceDamage(Character character, int hitReceived) {
        int receiveHit = character.receiveHit(hitReceived);
        if (receiveHit > 0) {
            int armorValue = this.getArmorValue();
            receiveHit = receiveHit - armorValue;
            Printer.println(this.getName() + " reduces " + armorValue + " damage points", Printer.PrinterColor.COLOR_YELLOW);
            return receiveHit;

        }
        return receiveHit;
    }

    public int getArmorValue() {
        return armorValue;
    }
}
