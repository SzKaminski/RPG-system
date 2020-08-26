package com.gameloop;

import com.characters.Hero;
import com.characters.Villain;
import com.visualeffects.Printer;

public class FightLoop implements Runnable {

    private boolean isRunning;

    private Hero hero;
    private Villain villain;

    public FightLoop(Hero hero, Villain villain) {
        this.hero = hero;
        this.villain = villain;
    }

    @Override
    public void run() {
        start();
        while (isRunning){

            Printer.println("Combat between " + hero.getName() + " and " + villain.getName() + " starts");
            int heroPower = hero.getHealthPoints()
                    + hero.getEndurance()
                    + hero.getManaPoints()
                    + hero.getIntelligence()
                    + hero.getMeleeAttack()
                    + hero.getStrenght()
                    + hero.getDodge()
                    + hero.getDexterity();


            int villainPower = villain.getHealthPoints()
                    + villain.getEndurance()
                    + villain.getManaPoints()
                    + villain.getIntelligence()
                    + villain.getMeleeAttack()
                    + villain.getStrenght()
                    + villain.getDodge()
                    + villain.getDexterity();
            int i = heroPower - villainPower;
            System.out.println(i);
            if (i>0){
                System.out.println("Hero wins");
                int exp = hero.getExperiencePoints() + getExperienceGained(villain);
                hero.setExperiencePoints(exp);
                System.out.println(hero.getExperiencePoints());
            }else
                System.out.println("Hero lose");
            stop();
        }
    }

    private int getExperienceGained(Villain villain){
        int experience = villain.getHealthPoints()
                + villain.getEndurance()
                + villain.getManaPoints()
                + villain.getIntelligence()
                + villain.getMeleeAttack()
                + villain.getStrenght()
                + villain.getDodge()
                + villain.getDexterity();

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
