package com.characters;

import com.classes.CharacterClass;

public class Villain extends Character {

    //todo: depends on vil's lvl one should have an alias instead of a number as a level next to name when the combat starts

    private String name;
    private CharacterClass characterClass;

    public Villain() {
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

        this.setBasicHealthPoints();
        this.setBasicManaPoints();
        this.setBasicMeleeAttack();
        this.setBasicDodge();

        this.setActualHealthPoints(getHealthPoints());
    }

}
