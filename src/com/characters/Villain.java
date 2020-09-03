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
