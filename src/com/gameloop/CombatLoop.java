package com.gameloop;

import com.characters.Hero;
import com.characters.Villain;
import com.visualeffects.Printer;

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

            Printer.println("Combat between " + hero.getName() + " and " + villain.getName() + " starts");
            int heroPower = hero.getHealthPoints()
                    + hero.getEndurance()
                    + hero.getManaPoints()
                    + hero.getIntelligence()
                    + hero.getMeleeAttack()
                    + hero.getStrenght()
                    + hero.getDodge()
                    + hero.getDexterity();

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
        return villain.getHealthPoints()
                + villain.getEndurance()
                + villain.getManaPoints()
                + villain.getIntelligence()
                + villain.getMeleeAttack()
                + villain.getStrenght()
                + villain.getDodge()
                + villain.getDexterity();
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
