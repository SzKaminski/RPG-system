package com.szkaminski.RPG.characters.rpcs;

import com.szkaminski.RPG.characters.Hero;
import com.szkaminski.RPG.characters.characterEnums.Overall_health;

public class Alderman extends Hero {

    public Alderman() {
        super();

        setOverall_health(Overall_health.FEELS_GOOD);
//        setName("Alderman");
//        setGold(500);
//        setGender(Gender.MAN);
//        setLevel(15);
//        /*setStrength(new Strength(30));
//        setDexterity(new Dexterity(5));
//        setEndurance(new Endurance(20));
//        setIntelligence(new Intelligence(10));*/
//        setCharacterClass(new AldermanClass());
//        setLocation(new MarketPlace());
//        setLevel(15);
//        computeAttributesByActualCharacterStats();
//
//        setActualHealthPoints(getHealthPoints());
        /*setCharacterClass(new CharacterClass() {
            @Override
            public String getName() {
                return "AldermanClass";
            }
        });*/
    }
}
