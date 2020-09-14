package com.gameloops;

import com.builder.HeroBuilder;
import com.characters.Hero;
import com.classes.CharacterClass;
import com.classes.ClassesContainer;
import com.places.MarketPlace;

import java.util.List;
import java.util.Scanner;

import static com.visualeffects.PauseEffect.pause;
import static com.visualeffects.Printer.PrinterColor;
import static com.visualeffects.Printer.println;

public class MainLoop implements Runnable {

    private Scanner sc;
    private boolean isRunning;
    private Hero hero;

    private List<CharacterClass> characterClasses;

    private MarketPlace marketPlace;

    public MainLoop() {
        sc = new Scanner(System.in);
        characterClasses = new ClassesContainer().getCharacterClassList();
        marketPlace = new MarketPlace();
    }

    @Override
    public void run() {
        start();
        while (isRunning) {
            createProtagonist();
            pause();
            heroLocation();
            stop();
        }
    }

    public void heroLocation() {

        hero.getLocation().enter(hero);
    }

    private void createProtagonist() {
        println("Please create new character.", PrinterColor.COLOR_YELLOW);
        println("Enter character's name:", PrinterColor.COLOR_YELLOW);
        String characterName = sc.nextLine();

        CharacterClass characterClass = chooseCharacterClass();

        hero = new HeroBuilder()
                .withName(characterName)
                .withCharacterClass(characterClass)
                .withLocation(new MarketPlace())
                .build();
    }

    private CharacterClass chooseCharacterClass() {
        System.out.println("Choose a character's class");
        for (int i = 0; i < characterClasses.size(); i++) {
            System.out.println(i + 1 + ") " + characterClasses.get(i).getName());
        }
        String playerInput = sc.nextLine();

        return getClassFromList(playerInput);
    }

    private CharacterClass getClassFromList(String className) {
        if (className.matches("-?\\d+")) {
            for (int i = 0; i < characterClasses.size(); i++) {
                if (i == Integer.parseInt(className)) {
                    return characterClasses.get(i - 1);
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
