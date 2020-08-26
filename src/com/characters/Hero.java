package com.characters;

import com.classes.CharacterClass;

public class Hero extends Character {

    private String name;
    private CharacterClass characterClass;
    private int experiencePoints;
    private int newLevelPoints;

    public Hero() {
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

    public void setAttributes(){
        this.setHealthPoints(getCharacterClass().getHealthPoints());
        this.setEndurance(getCharacterClass().getEndurance());
        this.setManaPoints(getCharacterClass().getManaPoints());
        this.setIntelligence(getCharacterClass().getIntelligence());
        this.setMeleeAttack(getCharacterClass().getMeleeAttack());
        this.setStrenght(getCharacterClass().getStrenght());
        this.setDodge(getCharacterClass().getDodge());
        this.setDexterity(getCharacterClass().getDexterity());
    }

}
