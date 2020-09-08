package com.items;

import com.characters.Character;

import java.util.Random;

public abstract class Item {

    private String name;
    private ItemType itemType;
    private int value;
    private ItemCondition condition;
    private boolean equipped;
    private Random drawNumber;

    public Item() {
    }

    public Item(String name, ItemType itemType, int value, ItemCondition condition) {
        this.name = name;
        this.itemType = itemType;
        this.value = value;
        this.condition = condition;

    }

    public Item(String name, ItemType itemType, int value) {
        this.name = name;
        this.itemType = itemType;
        this.value = value;
    }

    public Random getDrawNumber() {
        return new Random();
    }

    //todo: i want to create special attributes for all items
   // public abstract void getSpecialAttribute();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ItemCondition getCondition() {
        return condition;
    }

    public void setCondition(ItemCondition condition) {
        this.condition = condition;
    }

    public boolean isCondidionMet(Character character){
        return character.getAttribute().getValue() >= condition.getValue();
    }

    public void setEquipped(boolean equipped) {
        this.equipped = equipped;
    }

    public boolean isEquipped() {
        return equipped;
    }
}
