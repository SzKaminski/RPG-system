package com.gameloop;

import com.builder.HeroBuilder;
import com.characters.Hero;
import com.characters.Villain;
import com.classes.*;
import com.visualeffects.Printer;

import java.util.*;

public class MainLoop implements Runnable {

    private Scanner sc;
    private boolean isRunning;
    private Hero hero;
    private Villain randomVillain;
    private List<CharacterClass> characterClasses;
    private FightLoop fightLoop;

    public MainLoop() {
        sc = new Scanner(System.in);
        characterClasses = new ClassesContainer().getCharacterClassList();
    }

    @Override
    public void run() {
        start();
        while (isRunning) {
            createProtagonist();
            pause();
            firstMeet();
            fightLoop = new FightLoop(hero, randomVillain);
            fightLoop.run();
            stop();
        }
    }

    private void pause() {
        try {
            for (int i = 0; i < 3; i++) {
                System.out.print(".");
                Thread.sleep(800);
            }
            System.out.print("\n");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void firstMeet() {
        System.out.println();
        Printer.println(hero.getName() + " the " + hero.getCharacterClass().getName() + " meets an opponent");
        pause();
        Villain villain = new Villain();
        randomVillain = villain.getRandomVillain();


        System.out.println(randomVillain.getName() +
                " " + randomVillain.getCharacterClass().getName() +
                " " + randomVillain.getLevel());



    }

    private void createProtagonist() {
        Printer.println("Please create new character.");
        Printer.println("Enter character's name:");
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

    private CharacterClass getFromList(String className) {
        if (className.matches("-?\\d+")) {
            for (int i = 0; i < characterClasses.size(); i++) {
                if (i == Integer.parseInt(className)) {
                    return characterClasses.get(i);
                }
            }
        } else {
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
