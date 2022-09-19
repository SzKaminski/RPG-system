package com.szkaminski.RPG.builders;

import com.szkaminski.RPG.characters.Hero;
import com.szkaminski.RPG.characters.characterEnums.Gender;
import com.szkaminski.RPG.characters.characterEnums.Weapon;
import com.szkaminski.RPG.places.Place;

public class HeroBuilder {

    private Hero hero;

    public HeroBuilder() {
        this.hero = new Hero();
    }

    public HeroBuilder withName(String name){
        hero.setName(name);
        return this;
    }

    public HeroBuilder withGender(Gender gender){
        hero.setGender(gender);
        return this;
    }
//    public HeroBuilder withCharacterClass(CharacterClass characterClass){
//        hero.setCharacterClass(characterClass);
//        return this;
//    }
//
    public HeroBuilder withLocation(Place location){
        hero.setLocation(location);
        return this;
    }

    public Hero build(){
        return hero;
    }

    public HeroBuilder withWeapon(Weapon bow) {
        hero.setWeapon(bow);
        return this;
    }
}
