package com.builder;

import com.characters.Villain;
import com.classes.CharacterClass;
import com.classes.ClassesContainer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomVillainBuilder {

    private Villain villain;
    private Random r;
    private List<String> firstNameList;
    private List<String> aliasNameList;
    private List<CharacterClass> characterClasses;

    public RandomVillainBuilder() {
        this.villain = new Villain();
        this.r = new Random();
        characterClasses = new ClassesContainer().getCharacterClassList();
    }

    public RandomVillainBuilder withName() {
        this.firstNameList = new ArrayList<>();
        this.aliasNameList = new ArrayList<>();
        firstNameList.addAll(Arrays.asList("Five Fingers",
                "Emmerson",
                "Eldridge",
                "Bret",
                "Lang",
                "Radford",
                "Rowan",
                "Ashton",
                "Wynton" ));

        aliasNameList.addAll(Arrays.asList("Skyler",
                "Knuckles",
                "Whisperless",
                "Pillager",
                "Brute",
                "Crackpot",
                "Prowling",
                "Bullseye",
                "Sweet",
                "Phantom",
                "Keegan"
        ));
        villain.setName(aliasNameList.get(r.nextInt(aliasNameList.size())) +
                " " + firstNameList.get(r.nextInt(firstNameList.size())));
        return this;
    }

    public RandomVillainBuilder withCharacterClass() {
        villain.setCharacterClass(characterClasses.get(r.nextInt(characterClasses.size())));
        return this;
    }

    public RandomVillainBuilder withRandomLvl() {
        villain.setLevel(r.nextInt(2) + 1);
        return this;
    }

    public Villain build() {
        return villain;
    }
}
