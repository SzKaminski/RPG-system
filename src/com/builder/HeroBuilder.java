package com.builder;

import com.characters.Hero;
import com.classes.CharacterClass;

public class HeroBuilder {

    private Hero hero;

    public HeroBuilder() {
        this.hero = new Hero();
    }

    public HeroBuilder withName(String name){
        hero.setName(name);
        return this;
    }

    public HeroBuilder withCharacterClass(CharacterClass characterClass){
        hero.setCharacterClass(characterClass);
        return this;
    }

    public Hero build(){
        return hero;
    }

}
