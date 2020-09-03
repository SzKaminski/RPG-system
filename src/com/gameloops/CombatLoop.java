package com.gameloops;

import com.characters.Character;
import com.characters.Hero;
import com.characters.Villain;

import static com.visualeffects.PauseEffect.pause;
import static com.visualeffects.Printer.println;

public class CombatLoop implements Runnable {

    private boolean isRunning;

    private Hero hero;
    private Villain villain;

    public CombatLoop(Hero hero, Villain villain) {
        this.hero = hero;
        this.villain = villain;
    }

    @Override
    public void run() {
        start();
        while (isRunning) {
            pause();
            println("Combat between " + hero.getName() + " and " + villain.getName() + " starts", "\u001B[33m");
            getCharactersStatistics();
            Character winner = getCombatLoop();

            if (winner == hero) {
                println(hero.getName() + " wins", "\u001B[34m");
                int exp = hero.getExperiencePoints() + getExperienceGained(villain);
                hero.setExperiencePoints(exp);
                hero.checkIfNewLevel();
                MainLoop mainLoop = new MainLoop();
                mainLoop.setHero(hero);
                mainLoop.combatMeet();
            } else
                println(hero.getName() + " loses", "\u001B[31m");
            stop();

        }
    }

    private void getCharactersStatistics() {
        println(hero.getName() + " lvl." + hero.getLevel() + " || lvl." + villain.getLevel() + " " + villain.getName(), "\u001B[31m");
        System.out.println("      Str:" + hero.getStrenght().getValue() + " || " + villain.getStrenght().getValue());
        System.out.println("      Dex:" + hero.getDexterity().getValue() + " || " + villain.getDexterity().getValue());
        System.out.println("      End:" + hero.getEndurance().getValue() + " || " + villain.getEndurance().getValue());
        System.out.println("      Int:" + hero.getIntelligence().getValue() + " || " + villain.getIntelligence().getValue());
        System.out.println();
        System.out.println("      Attack: " + hero.getMeleeAttack().getValue() + " || " + villain.getMeleeAttack().getValue());
        System.out.println("      HP: " + hero.getHealthPoints().getValue() + " || " + villain.getHealthPoints().getValue());
        pause();
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

        println("Experience +" + experience, "\u001B[33m");

        return experience;
    }

    private void start() {
        isRunning = true;
    }

    private void stop() {
        isRunning = false;
    }

    private Character getCombatLoop() {
        // todo: need to refactor that
        Character attacker;
        Character defender;
        String attackerName;
        String defenderName;
        int actualAttackerHP;
        int actualDefenderHP;

        //todo: that if state is not a best solution, additionally actual HPs are static - actual value
        // causes a sudden loss bug at the start of the 5th fight
        if (hero.getDexterity().getValue() > villain.getDexterity().getValue()) {
            attacker = hero;
            attackerName = hero.getName();
            defender = villain;
            defenderName = villain.getName();
            actualAttackerHP = hero.getHealthPoints().getValue();
            actualDefenderHP = villain.getHealthPoints().getValue();
        } else {
            attacker = villain;
            attackerName = villain.getName();
            defender = hero;
            defenderName = hero.getName();

            actualAttackerHP = villain.getHealthPoints().getValue();
            actualDefenderHP = hero.getHealthPoints().getValue();
        }

        System.out.println();
        while (true) {
            println(attackerName + " attacks " + defenderName, "\u001B[31m");
            System.out.println(actualAttackerHP + "/" + attacker.getHealthPoints().getValue() + "          ||          " +
                    actualDefenderHP + "/" + defender.getHealthPoints().getValue());
            int attackerValue = attacker.getMeleeAttack().getValue();
            System.out.println("Damages: " + attackerValue);
            actualDefenderHP = actualDefenderHP - attackerValue;
            defender.getHealthPoints().setActualValue(actualDefenderHP);

            if (actualDefenderHP <= 0)
                return attacker;

            pause();

            println(defenderName + " attacks " + attackerName, "\u001B[36m");
            System.out.println(actualAttackerHP + "/" + attacker.getHealthPoints().getValue() + "          ||          " +
                    actualDefenderHP + "/" + defender.getHealthPoints().getValue());
            int defenderValue = defender.getMeleeAttack().getValue();
            System.out.println("Damages: " + defenderValue);
            actualAttackerHP = actualAttackerHP - defenderValue;
            defender.getHealthPoints().setActualValue(actualAttackerHP);

            if (actualAttackerHP <= 0)
                return defender;

            pause();
        }
    }
}
