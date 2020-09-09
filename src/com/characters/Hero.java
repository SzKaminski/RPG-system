package com.characters;

import com.characters.characterAttributes.Dexterity;
import com.characters.characterAttributes.Endurance;
import com.characters.characterAttributes.Intelligence;
import com.characters.characterAttributes.Strength;
import com.classes.CharacterClass;
import com.items.Item;
import com.items.playable.ammunition.Ammunition;
import com.items.playable.amulets.Amulet;
import com.items.playable.armors.Armor;
import com.items.playable.armors.PeasantShirt;
import com.items.playable.consumables.Cheese;
import com.items.playable.consumables.Consumable;
import com.items.playable.shields.OldWoodenShield;
import com.items.playable.shields.Shield;
import com.items.playable.weapons.Branch;
import com.items.playable.weapons.Weapon;
import com.visualeffects.Printer;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.visualeffects.PauseEffect.pause;

public class Hero extends Character {

    private String name;
    private CharacterClass characterClass;
    private int experiencePoints;
    private int newLevelPoints = 50;
    private int increasePoints = 3;
    private Scanner sc;

    public Hero() {
        //todo: added eq on start may not increase combat stats
        Shield woodenShield = new OldWoodenShield();
        getItems().add(woodenShield);
        woodenShield.setEquipped(true);
        setEquippedShield(woodenShield);
        PeasantShirt peasantShirt = new PeasantShirt();
        getItems().add(peasantShirt);
        peasantShirt.setEquipped(true);
        setEquippedArmor(peasantShirt);
        Cheese cheese = new Cheese();
        getItems().add(cheese);
    }

    public void checkIfNewLevel() {
        System.out.println("Next lvl: " + experiencePoints + "/" + newLevelPoints);

        if (experiencePoints >= newLevelPoints) {
            int levelUp = this.getLevel() + 1;
            setLevel(levelUp);
            System.out.println("You have reached new level: " + levelUp);
            newLevelPoints = newLevelPoints * 3;
            increasePoints = 3;
            getStatisticsIncreaser();

        }
    }

    public int getStatisticsIncreaser() {

        sc = new Scanner(System.in);
        Printer.println("Develop attributes | Points to use: " + increasePoints, Printer.PrinterColor.COLOR_YELLOW);

        System.out.println("1) " + getStrength().getShortcut() + ": " + getStrength().getValue() + " +1");
        System.out.println("2) " + getDexterity().getShortcut() + ": " + getDexterity().getValue() + " +1");
        System.out.println("3) " + getEndurance().getShortcut() + ": " + getEndurance().getValue() + " +1");
        System.out.println("4) " + getIntelligence().getShortcut() + ": " + getIntelligence().getValue() + " +1");

        String s = sc.nextLine();
        switch (s) {
            case "1":
                setStrength(new Strength(getStrength().getValue() + 1));
                increasePoints = increasePoints - 1;
                break;
            case "2":
                setDexterity(new Dexterity(getDexterity().getValue() + 1));
                increasePoints = increasePoints - 1;
                break;
            case "3":
                setEndurance(new Endurance(getEndurance().getValue() + 1));
                increasePoints = increasePoints - 1;
                break;
            case "4":
                setIntelligence(new Intelligence(getIntelligence().getValue() + 1));
                increasePoints = increasePoints - 1;
                break;
            default:
                System.out.println("Type 1-4");
                break;
        }
        increaseAttributes();
        if (increasePoints > 0) {
            getStatisticsIncreaser();
        }
        return increasePoints;
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }

    public void setExperiencePoints(int experiencePoints) {
        this.experiencePoints = experiencePoints;
    }

    public int getNewLevelPoints() {
        return newLevelPoints;
    }

    public void setNewLevelPoints(int newLevelPoints) {
        this.newLevelPoints = newLevelPoints;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CharacterClass getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(CharacterClass characterClass) {
        this.characterClass = characterClass;
        this.setAttributes();
    }

    public void setAttributes() {
        this.setEndurance(getCharacterClass().getEndurance());
        this.setIntelligence(getCharacterClass().getIntelligence());
        this.setStrength(getCharacterClass().getStrength());
        this.setDexterity(getCharacterClass().getDexterity());

        computeAttributesByActualCharacterStats();

        this.setActualHealthPoints(getHealthPoints());
    }

    public void increaseAttributes() {
        this.setEndurance(getEndurance());
        this.setIntelligence(getIntelligence());
        this.setStrength(getStrength());
        this.setDexterity(getDexterity());
        computeAttributesByActualCharacterStats();
    }

    private void computeAttributesByActualCharacterStats() {
        this.setBasicHealthPoints();
        this.setBasicManaPoints();
        this.setBasicMeleeAttack();
        this.setBasicDodge();
    }

    public void manageEquipment() {

        if (!getItems().isEmpty()) {
            Printer.println("Equipment: ", Printer.PrinterColor.COLOR_GREEN);
            for (int i = 0; i < getItems().size(); i++) {
                if (getItems().get(i).isEquipped()) {
                    Printer.println(i + ")- " + getItems().get(i).getName() + "(equipped) ", Printer.PrinterColor.COLOR_GREEN);
                } else
                    System.out.println(i + ")- " + getItems().get(i).getName() + " | value: " + getItems().get(i).getValue());
            }
        } else {
            System.out.println("Equipment is empty!");
            return;
        }

        System.out.println("Type 'e' + item number to equip/unequip item or 'r' + item number to remove");

        Scanner eqScanner = new Scanner(System.in);
        String manageItem = eqScanner.nextLine();

        int itemNumber = 0;
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(manageItem);
        while (m.find()) {
            itemNumber = Integer.parseInt(m.group());
        }
        try {

            Item item = getItems().get(itemNumber);

            if (manageItem.equals("e" + itemNumber)) {
                equipItemByType(item);
            } else if (manageItem.equals("r" + itemNumber)) {
                removeItemByType(item);
            }

        } catch (IndexOutOfBoundsException e) {
            Printer.println("Try something else", Printer.PrinterColor.COLOR_RED);
        }
    }

    public void equipItemByType(Item item) {
        switch (item.getItemType()) {
            case WEAPON:
                if (!item.isEquipped()) {
                    if (this.getEquippedWeapon() == null) {
                        this.setEquippedWeapon((Weapon) item);
                        //todo: won't work for villain equipment
                        this.increaseAttack();
                        System.out.println(item.getName() + " equipped");
                    } else {
                        System.out.println("you cannot equip another weapon");
                    }
                } else {
                    this.unEquipWeapon((Weapon) item);
                    this.increaseAttack();

                    System.out.println(item.getName() + " unequipped");
                }
                pause();
                break;
            case ARMOR:
                if (!item.isEquipped()) {
                    if (this.getEquippedArmor() == null) {
                        this.setEquippedArmor((Armor) item);
                        //todo: won't work for villain equipment
                        this.increaseDefense();
                        System.out.println(item.getName() + " equipped");
                    } else {
                        System.out.println("you cannot equip another armor");
                    }
                } else {
                    this.unEquipArmor((Armor) item);
                    this.increaseDefense();
                    System.out.println(item.getName() + " unequipped");
                }
                pause();
                break;
            case AMULET:
                if (!item.isEquipped()) {
                    if (this.getEquippedAmulet() == null) {
                        this.setEquippedAmulet((Amulet) item);
                        //todo: won't work for villain equipment
                       // this.increaseDefense();
                        System.out.println(item.getName() + " equipped");
                    } else {
                        System.out.println("you cannot equip another amulet");
                    }
                } else {
                    this.unEquipAmulet((Amulet) item);
                  //  this.increaseDefense();
                    System.out.println(item.getName() + " unequipped");
                }
                pause();
                break;
            case AMMUNITION:
                if (!item.isEquipped()) {
                    if (this.getEquippedAmmunition() == null) {
                        this.setEquippedAmmunition((Ammunition) item);
                        //todo: won't work for villain equipment
                        // this.increaseDefense();
                        System.out.println(item.getName() + " equipped");
                    } else {
                        System.out.println("you cannot equip another ammunition");
                    }
                } else {
                    this.unEquipAmmunition((Ammunition) item);
                    //  this.increaseDefense();
                    System.out.println(item.getName() + " unequipped");
                }
                pause();
                break;
            case SHIELD:
                if (!item.isEquipped()) {
                    if (this.getEquippedShield() == null) {
                        this.setEquippedShield((Shield) item);
                        //todo: won't work for villain equipment
                        // this.increaseDefense();
                        System.out.println(item.getName() + " equipped");
                    } else {
                        System.out.println("you cannot equip another shield");
                    }
                } else {
                    this.unEquipShield((Shield) item);
                    //  this.increaseDefense();
                    System.out.println(item.getName() + " unequipped");
                }
                pause();
                break;
            case CONSUMABLE:
                Consumable consumable = (Consumable) item;
                consumable.consume(this);
                this.getItems().remove(item);
                pause();
                break;
            default:
                break;
        }
    }

    public void removeItemByType(Item item) {
        switch (item.getItemType()) {
            case WEAPON:
                this.unEquipWeapon((Weapon) item);
                this.increaseAttack();
                this.getItems().remove(item);
                System.out.println(item.getName() +" removed");
                break;
            case ARMOR:
                this.unEquipArmor((Armor) item);
                this.increaseDefense();
                this.getItems().remove(item);
                System.out.println(item.getName() +" removed");
                break;
            case AMULET:
                this.unEquipAmulet((Amulet) item);
               // this.increaseDefense();
                this.getItems().remove(item);
                System.out.println(item.getName() +" removed");
                break;
            case AMMUNITION:
                this.unEquipAmmunition((Ammunition) item);
                // this.increaseDefense();
                this.getItems().remove(item);
                System.out.println(item.getName() +" removed");
                break;
            case SHIELD:
                this.unEquipShield((Shield) item);
                // this.increaseDefense();
                this.getItems().remove(item);
                System.out.println(item.getName() +" removed");
                break;
            case CONSUMABLE:
                this.getItems().remove(item);
                System.out.println(item.getName() +" removed");
                break;
            default:
                break;
        }
    }

}
