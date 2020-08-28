package com.characters;

import com.classes.CharacterClass;

public class Villain extends Character {

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
        this.setHealthPoints(getCharacterClass().getEndurance());
        this.setEndurance(getCharacterClass().getEndurance());
        this.setManaPoints(getCharacterClass().getIntelligence());
        this.setIntelligence(getCharacterClass().getIntelligence());
        this.setMeleeAttack(getCharacterClass().getStrenght());
        this.setStrenght(getCharacterClass().getStrenght());
        this.setDodge(getCharacterClass().getDexterity());
        this.setDexterity(getCharacterClass().getDexterity());
    }

    public void increseAttributes(){
        this.setHealthPoints(getEndurance());
        this.setEndurance(getEndurance());
        this.setManaPoints(getIntelligence());
        this.setIntelligence(getIntelligence());
        this.setMeleeAttack(getStrenght());
        this.setStrenght(getStrenght());
        this.setDodge(getDexterity());
        this.setDexterity(getDexterity());
    }

}
