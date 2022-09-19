package com.szkaminski.RPG.characters;

import com.szkaminski.RPG.characters.Items.Equipment;
import com.szkaminski.RPG.characters.Items.Item;
import com.szkaminski.RPG.characters.characterEnums.Gender;
import com.szkaminski.RPG.characters.characterEnums.Weapon;
import com.szkaminski.RPG.places.Place;

public abstract class Character {

    //    private int level = 1;
//
//    private CharAttribute charAttribute;
    private String name;
    //
//    private int gold;
    private Place location;
//
//    private Strength strength;
//    private Dexterity dexterity;
//    private Endurance endurance;
//    private Intelligence intelligence;
//
//    private MeleeAttack meleeAttack;
//    private Dodge dodge;
//    private HealthPoints healthPoints;
//    private HealthPoints actualHealthPoints;
//    private ManaPoints manaPoints;
//
//    private Weapon equippedWeapon;
//    private Armor equippedArmor;
//    private Amulet equippedAmulet;
//    private Ammunition equippedAmmunition;
//    private Shield equippedShield;
//
    private Equipment<Item> items;
//
//    private String description;
//
//
    public Character() {
        items = new Equipment<>();
    }
//
//    public Character(Strength strength,
//                     Dexterity dexterity,
//                     Endurance endurance,
//                     Intelligence intelligence) {
//        this.strength = strength;
//        this.dexterity = dexterity;
//        this.endurance = endurance;
//        this.intelligence = intelligence;
//        items = new Equipment<>();
//    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Gender gender;

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Place getLocation() {
        return location;
    }

    public void setLocation(Place location) {
        this.location = location;
    }


    public void setWeapon(Weapon bow) {
    }
}
