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
    private CombatLoop combatLoop;

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
            combatMeet();
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

    public void combatMeet() {
        System.out.println();
        Printer.println(hero.getName() + " the " + hero.getCharacterClass().getName() + " meets an opponent");
        pause();
        Villain villain = new Villain();
        randomVillain = villain.getRandomVillain();

        System.out.println(randomVillain.getName() +
                " " + randomVillain.getCharacterClass().getName() +
                " " + randomVillain.getLevel());
        chooseAction();

    }

    private void chooseAction() {
        System.out.println("Choose an action");
        int i = 0;
        System.out.println(i+1 + ") Fight!");
        System.out.println(i+2 + ") Try to avoid");
        String getPick = sc.nextLine();

        if (getPick.equals("1")){
            combatLoop = new CombatLoop(hero, randomVillain);
            stop();
            combatLoop.run();

        } else
            combatMeet();

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

        return getClassFromList(playerInput);
    }

    private CharacterClass getClassFromList(String className) {
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

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    private void start() {
        isRunning = true;
    }

    private void stop() {
        isRunning = false;
    }
}
