package com.gameloop;

import com.builder.HeroBuilder;
import com.characters.Hero;
import com.classes.CharacterClass;
import com.classes.Warrior;

import java.util.Scanner;

public class MainLoop implements Runnable {

    private Scanner sc;
    private boolean isRunning;
    private Hero hero;

    public MainLoop() {
        sc = new Scanner(System.in);
    }

    @Override
    public void run() {
        start();
        while (isRunning) {
            createProtagonist();


            System.out.println(hero.getName());
            System.out.println(hero.getCharacterClass().getName());
            System.out.println(hero.getHealthPoints());
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
        System.out.println("1. Warrior");
        String characterClass = sc.nextLine();

        if (characterClass.equals("1") || characterClass.equals("Warrior")){
            return new Warrior();
        }
        return null;
    }

    private void start(){
        isRunning = true;
    }

    private void stop(){
        isRunning = false;
    }
}
