package com.classes;

import com.classes.playable.Mage;
import com.classes.playable.Rogue;
import com.classes.playable.Warrior;

import java.util.ArrayList;
import java.util.List;

public class ClassesContainer {

    //todo: need to find some fancy solution for this

    private List<CharacterClass> characterClassList;

    public ClassesContainer() {
        this.characterClassList = new ArrayList<>();
        characterClassList.add(new Warrior());
        characterClassList.add(new Mage());
        characterClassList.add(new Rogue());
    }

    public List<CharacterClass> getCharacterClassList() {

        return characterClassList;
    }
}
