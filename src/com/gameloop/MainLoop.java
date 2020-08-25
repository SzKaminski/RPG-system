package com.gameloop;

import com.builder.HeroBuilder;
import com.characters.Hero;
import com.classes.CharacterClass;
import com.classes.Mage;
import com.classes.Rogue;
import com.classes.Warrior;

import java.util.*;

public class MainLoop implements Runnable {

    private Scanner sc;
    private boolean isRunning;
    private Hero hero;
    private List<CharacterClass> characterClasses;

    public MainLoop() {
        sc = new Scanner(System.in);

        //todo: need to simplify classes list creating
        characterClasses = new ArrayList<>();
        characterClasses.add(new Warrior());
        characterClasses.add(new Mage());
        characterClasses.add(new Rogue());
    }

    @Override
    public void run() {

        start();
        while (isRunning) {
            createProtagonist();

            
            stop();
        }
    }

    private void createProtagonist() {
        System.out.println("Please create new character.");
        System.out.println("Enter character's name:");
        String characterName = sc.nextLine();

        CharacterClass characterClass = chooseCharacterClass();

        hero = new HeroBuilder()
                .withName(characterName)
                .withCharacterClass(characterClass)
                .build();
    }

    private CharacterClass chooseCharacterClass() {
        System.out.println("Choose a character's class");
        for (int i = 0; i < characterClasses.size(); i++) {
            System.out.println(i + ") " + characterClasses.get(i).getName());
        }
        String playerInput = sc.nextLine();

        return getFromList(playerInput);
    }

    private CharacterClass getFromList(String className){

        if (className.matches("-?\\d+")){
            for (int i = 0; i < characterClasses.size(); i++) {
                if (i == Integer.parseInt(className)){
                    return characterClasses.get(i);
                }
            }
        }else {
            for (CharacterClass c : characterClasses) {
                if (className.equals(c.getName())) {
                    return c;
                }
            }
        }
        return null;
    }

    private void start() {
        isRunning = true;
    }

    private void stop() {
        isRunning = false;
    }
}
