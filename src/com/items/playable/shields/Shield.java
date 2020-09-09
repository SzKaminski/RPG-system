package com.items.playable.shields;

import com.characters.Character;
import com.items.Item;
import com.items.ItemType;
import com.visualeffects.Printer;

public class Shield extends Item {

    private double blockChance;
    private int blockValue;

    public Shield() {
    }

    public Shield(String name, int value, double blockChance, int blockValue) {
        super(name, ItemType.SHIELD, value);
        this.blockChance = blockChance;
        this.blockValue = blockValue;
    }

    public int block(Character character, int hitReceived) {
        int receiveHit = character.receiveHit(hitReceived);
        if (receiveHit > 0) {
            boolean blockChance = this.getBlockChance();
            int blockValue = this.getBlockValue();
            if (blockChance) {
                receiveHit = receiveHit - blockValue;
                Printer.println( this.getName() + " blocks " + blockValue + " damage points", Printer.PrinterColor.COLOR_YELLOW);
                return receiveHit;
            }
        }
        return receiveHit;
    }

    private int getBlockValue() {
        return blockValue;
    }

    private boolean getBlockChance() {
        return getDrawNumber().nextDouble() > 1.0 - this.blockChance;
    }
}
