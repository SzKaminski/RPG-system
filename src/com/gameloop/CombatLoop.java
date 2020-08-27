package com.gameloop;

import com.characters.Hero;
import com.characters.Villain;
import com.visualeffects.Printer;

import static com.visualeffects.PauseEffect.pause;

public class CombatLoop implements Runnable {

    private boolean isRunning;

    private Hero hero;
    private Villain villain;
    private MainLoop mainLoop;

    public CombatLoop(Hero hero, Villain villain) {
        this.hero = hero;
        this.villain = villain;
    }

    @Override
    public void run() {
        start();
        while (isRunning) {
            pause();
            Printer.println("Combat between " + hero.getName() + " and " + villain.getName() + " starts");
            int heroPower = hero.getHealthPoints().getValue()
                    + hero.getEndurance().getValue()
                    + hero.getManaPoints().getValue()
                    + hero.getIntelligence().getValue()
                    + hero.getMeleeAttack().getValue()
                    + hero.getStrenght().getValue()
                    + hero.getDodge().getValue()
                    + hero.getDexterity().getValue();

            System.out.println(hero.getName() + " lvl." + hero.getLevel() + " || lvl." + villain.getLevel() + " " + villain.getName());
            System.out.println("      Str:" + hero.getStrenght().getValue() + " || " + villain.getStrenght().getValue());
            System.out.println("      Dex:" + hero.getDexterity().getValue() + " || " + villain.getDexterity().getValue());
            System.out.println("      End:" + hero.getEndurance().getValue() + " || " + villain.getEndurance().getValue());
            System.out.println("      Int:" + hero.getIntelligence().getValue() + " || " + villain.getIntelligence().getValue());
            System.out.println();
            System.out.println("      Attack: "+ hero.getMeleeAttack().getValue() + " || " + villain.getMeleeAttack().getValue());
            System.out.println("      HP: "+ hero.getHealthPoints().getValue() + " || " + villain.getHealthPoints().getValue());
            int villainPower = getVillainPower(villain);
            int i = heroPower - villainPower;

            if (i > 0) {
                System.out.println("Hero wins");
                int exp = hero.getExperiencePoints() + getExperienceGained(villain);
                hero.setExperiencePoints(exp);
                hero.checkIfNewLevel();
                mainLoop = new MainLoop();
                mainLoop.setHero(hero);
                mainLoop.combatMeet();
            } else
                System.out.println("Hero loses");
            stop();
        }
    }

    private int getVillainPower(Villain villain) {
        return villain.getHealthPoints().getValue()
                + villain.getEndurance().getValue()
                + villain.getManaPoints().getValue()
                + villain.getIntelligence().getValue()
                + villain.getMeleeAttack().getValue()
                + villain.getStrenght().getValue()
                + villain.getDodge().getValue()
                + villain.getDexterity().getValue();
    }

    private int getExperienceGained(Villain villain) {
        int experience = getVillainPower(villain);

        Printer.println("Experience +" + experience);

        return experience;
    }

    private void start() {
        isRunning = true;
    }

    private void stop() {
        isRunning = false;
    }
}
