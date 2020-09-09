package com.gameloops;

import com.characters.Character;
import com.characters.Hero;
import com.characters.Villain;
import com.characters.characterAttributes.HealthPoints;
import com.items.Item;
import com.items.ItemsContainer;
import com.visualeffects.Printer;

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

    private ItemsContainer items;

    @Override
    public void run() {
        start();
        while (isRunning) {
            pause();
            println("Combat between " + hero.getName() + " and " + villain.getName() + " starts", Printer.PrinterColor.COLOR_YELLOW);
            getCharactersStatistics();
            Character winner = getCombatLoop();

            if (winner == hero) {
                victoryTemplate();
                items = new ItemsContainer();
                Item randomItem = items.getRandomItem();

                boolean add = hero.getItems().add(randomItem, hero);
                if (add)
                    println(hero.getName() + " hero found " + randomItem.getName(), Printer.PrinterColor.COLOR_PURPLE);
                else
                    println("You have too much stuff", Printer.PrinterColor.COLOR_RED);

                MainLoop mainLoop = new MainLoop();
                mainLoop.setHero(hero);
                mainLoop.combatMeet();

            } else
                println(hero.getName() + " loses", Printer.PrinterColor.COLOR_RED);
            stop();

        }
    }

    private void victoryTemplate() {
        println(hero.getName() + " wins", Printer.PrinterColor.COLOR_BLUE);
        int exp = hero.getExperiencePoints() + getExperienceGained(villain);
        hero.setExperiencePoints(exp);
        hero.checkIfNewLevel();
    }

    private void getCharactersStatistics() {
        println(hero.getName() + " lvl." + hero.getLevel() + " || lvl." + villain.getLevel() + " " + villain.getName(), Printer.PrinterColor.COLOR_YELLOW);
        System.out.println("      Str:" + hero.getStrength().getValue() + " || " + villain.getStrength().getValue());
        System.out.println("      Dex:" + hero.getDexterity().getValue() + " || " + villain.getDexterity().getValue());
        System.out.println("      End:" + hero.getEndurance().getValue() + " || " + villain.getEndurance().getValue());
        System.out.println("      Int:" + hero.getIntelligence().getValue() + " || " + villain.getIntelligence().getValue());
        System.out.println();

        if (hero.getEquippedWeapon() != null) {
            System.out.println("      Attack: " + hero.getMeleeAttack().getValue() + "(+" + hero.getEquippedWeapon().getBaseAttack() + ") || " + villain.getMeleeAttack().getValue());
        } else
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
                + villain.getStrength().getValue()
                + villain.getDodge().getValue()
                + villain.getDexterity().getValue();
    }

    private int getExperienceGained(Villain villain) {
        int experience = getVillainPower(villain);

        println("Experience +" + experience, Printer.PrinterColor.COLOR_YELLOW);

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

        if (hero.getDexterity().getValue() > villain.getDexterity().getValue()) {
            attacker = hero;
            attackerName = hero.getName();
            defender = villain;
            defenderName = villain.getName();
            actualAttackerHP = hero.getActualHealthPoints().getValue();
            actualDefenderHP = villain.getActualHealthPoints().getValue();
        } else {
            attacker = villain;
            attackerName = villain.getName();
            defender = hero;
            defenderName = hero.getName();

            actualAttackerHP = villain.getActualHealthPoints().getValue();
            actualDefenderHP = hero.getActualHealthPoints().getValue();
        }

        System.out.println();
        while (true) {
            println(attackerName + " attacks " + defenderName, Printer.PrinterColor.COLOR_RED);
            System.out.println(actualAttackerHP + "/" + attacker.getHealthPoints().getValue() + "          ||          " +
                    actualDefenderHP + "/" + defender.getHealthPoints().getValue());
            int attackerValue = attacker.getMeleeAttack().getValue();
            int i = defender.receiveHit(attackerValue);

            actualDefenderHP = actualDefenderHP - defender.getReceivedHit(i);

            defender.setActualHealthPoints(new HealthPoints(actualDefenderHP));
            if (actualDefenderHP <= 0)
                return attacker;

            pause();

            println(defenderName + " attacks " + attackerName, Printer.PrinterColor.COLOR_CYAN);
            System.out.println(actualAttackerHP + "/" + attacker.getHealthPoints().getValue() + "          ||          " +
                    actualDefenderHP + "/" + defender.getHealthPoints().getValue());
            int defenderValue = defender.getMeleeAttack().getValue();
            /*System.out.println("Damages: " + defenderValue);
            actualAttackerHP = actualAttackerHP - defenderValue;*/
            int j = attacker.receiveHit(defenderValue);
            actualAttackerHP = actualAttackerHP - attacker.getReceivedHit(j);

            attacker.setActualHealthPoints(new HealthPoints(actualAttackerHP));
            if (actualAttackerHP <= 0)
                return defender;

            pause();
        }
    }
}
