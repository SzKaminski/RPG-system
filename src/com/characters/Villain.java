package com.characters;

import com.builder.RandomVillainBuilder;
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
        this.setHealthPoints(getCharacterClass().getHealthPoints());
        this.setEndurance(getCharacterClass().getEndurance());
        this.setManaPoints(getCharacterClass().getManaPoints());
        this.setIntelligence(getCharacterClass().getIntelligence());
        this.setMeleeAttack(getCharacterClass().getMeleeAttack());
        this.setStrenght(getCharacterClass().getStrenght());
        this.setDodge(getCharacterClass().getDodge());
        this.setDexterity(getCharacterClass().getDexterity());
    }

    public Villain getRandomVillain() {

        return new RandomVillainBuilder()
                .withName()
                .withCharacterClass()
                .withRandomLvl()
                .build();

    }
}
