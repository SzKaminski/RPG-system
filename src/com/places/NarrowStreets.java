package com.places;

import com.builder.RandomVillainBuilder;
import com.characters.Hero;
import com.characters.Villain;
import com.gameloops.CombatLoop;
import com.visualeffects.Printer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.visualeffects.PauseEffect.pause;
import static com.visualeffects.Printer.println;

public class NarrowStreets extends Place {

    private final String DESCRIPTION = "narrow streets placeholder description";
    private List<Place> directions;
    private List<Object> targets;

    private Villain randomVillain;
    private CombatLoop combatLoop;


    public NarrowStreets() {
        super("Narrow Streets");
        setDescription(DESCRIPTION);

    }

    @Override
    public Map<String, Place> getDirections() {
        Map<String, Place> directions = new HashMap<>();
        directions.put("S", new MarketPlace());
        return directions;
    }

    @Override
    public void enter(Hero hero) {
        super.enter(hero);
        Map<String, Place> directions = hero.getLocation().getDirections();

        for (Map.Entry<String, Place> entry : directions.entrySet()) {
            System.out.print(entry.getKey() + " : " + entry.getValue().getName() + " | ");
        }
        System.out.println("\nI : open inventory");
        String getPick = getSc().nextLine().toLowerCase();

        if (isDigit(getPick))
            switch (getPick) {
                case "1":
                    //  getTargets().get(0).getConversation();
                    println("Local thug is approaching you", Printer.PrinterColor.COLOR_RED);
                    combatMeet(hero);
                    pause();
                    enter(hero);
                    break;
            }
        else
            setLocationDirections(hero, getPick);

    }

    public void combatMeet(Hero hero) {
        System.out.println();
        println(hero.getName() + " the " + hero.getCharacterClass().getName() + " meets an opponent", Printer.PrinterColor.COLOR_YELLOW);
        pause();
        randomVillain = new RandomVillainBuilder().withName()
                .withCharacterClass()
                .withRandomLvl()
                .build();

        chooseAction(hero);
    }

    private void chooseAction(Hero hero) {
        System.out.println(randomVillain.getName() +
                " " + randomVillain.getCharacterClass().getName() +
                " " + randomVillain.getLevel());

        System.out.println("Choose an action");
        int i = 0;
        System.out.println(i + 1 + ") Fight!");
        System.out.println(i + 2 + ") Try to avoid");
        System.out.println("I) Open equipment");
        String getPick = getSc().nextLine().toLowerCase();

        switch (getPick) {
            case "1":
                combatLoop = new CombatLoop(hero, randomVillain);
                combatLoop.run();
                break;
            case "2":
                enter(hero);
                break;
            case "i":
                hero.manageInventory();
                enter(hero);
                break;
            default:
                println("Type number to choose an option", Printer.PrinterColor.COLOR_RED);
                chooseAction(hero);
                break;
        }

    }

    private void setLocationDirections(Hero hero, String getPick) {
        switch (getPick) {
            case "n":

                break;
            case "e":
                break;
            case "s":
                MarketPlace marketPlace = new MarketPlace();
                hero.setLocation(marketPlace);
                marketPlace.enter(hero);
                break;
            case "w":
                break;
            case "i":
                hero.manageInventory();
                enter(hero);
                break;
            default:
                System.out.println("Wrong direction");
                break;
        }
    }
}
