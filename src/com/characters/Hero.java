package com.characters;

import com.characters.characterAttributes.*;
import com.classes.CharacterClass;
import com.visualeffects.Printer;

import java.util.Scanner;

public class Hero extends Character {

    private String name;
    private CharacterClass characterClass;
    private int experiencePoints;
    private int newLevelPoints = 50;
    private int increasePoints = 3;

    public Hero() {
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

        Scanner sc = new Scanner(System.in);
        Printer.println("Develop attributes | Points to use: " + increasePoints,"\u001B[33m");

        System.out.println("1) " + getStrenght().getShortcut() + ": " + getStrenght().getValue() + " +1");
        System.out.println("2) " + getDexterity().getShortcut() + ": " + getDexterity().getValue() + " +1");
        System.out.println("3) " + getEndurance().getShortcut() + ": " + getEndurance().getValue() + " +1");
        System.out.println("4) " + getIntelligence().getShortcut() + ": " + getIntelligence().getValue() + " +1");

        String s = sc.nextLine();
        switch (s) {
            case "1":
                setStrenght(new Strenght(getStrenght().getValue() + 1));
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
        this.updateHealthPoints(getCharacterClass().getEndurance());
        this.setEndurance(getCharacterClass().getEndurance());
        this.setManaPoints(getCharacterClass().getIntelligence());
        this.setIntelligence(getCharacterClass().getIntelligence());
        this.setMeleeAttack(getCharacterClass().getStrenght());
        this.setStrenght(getCharacterClass().getStrenght());
        this.setDodge(getCharacterClass().getDexterity());
        this.setDexterity(getCharacterClass().getDexterity());
    }

    public void increaseAttributes(){
        this.updateHealthPoints(getEndurance());
        this.setEndurance(getEndurance());
        this.setManaPoints(getIntelligence());
        this.setIntelligence(getIntelligence());
        this.setMeleeAttack(getStrenght());
        this.setStrenght(getStrenght());
        this.setDodge(getDexterity());
        this.setDexterity(getDexterity());
    }

}
