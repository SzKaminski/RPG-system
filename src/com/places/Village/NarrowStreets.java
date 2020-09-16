package com.places.Village;

import com.builder.RandomVillainBuilder;
import com.characters.Character;
import com.characters.Hero;
import com.characters.Villain;
import com.gameloops.CombatLoop;
import com.places.Place;
import com.visuals.Printer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.visuals.PauseEffect.pause;
import static com.visuals.Printer.println;

public class NarrowStreets extends Place {

    private final String DESCRIPTION = "narrow streets placeholder description";
    private List<Place> directions;
    private List<Object> targets;

    private Villain randomVillain;
    private CombatLoop combatLoop;


    public NarrowStreets() {
        super("Narrow Streets");
        setDescription(DESCRIPTION);
        randomVillain = new RandomVillainBuilder().withName()
                .withCharacterClass()
                .withRandomLvl()
                .build();
    }

    @Override
    public List<Character> getTargets() {
        List targets = new ArrayList<>();

        targets.add(randomVillain);
        return targets;
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
                default:
                    enter(hero);
                    break;
            }
        else
            setLocationDirections(hero, getPick, null, null, new MarketPlace(), null);

    }

    public void combatMeet(Hero hero) {
        System.out.println();
        println(hero.getName() + " the " + hero.getCharacterClass().getName() + " meets an opponent", Printer.PrinterColor.COLOR_YELLOW);
        pause();

        chooseAction(hero);
    }

    private void chooseAction(Hero hero) {
        Villain villain = (Villain) getTargets().get(0);
        System.out.println(villain.getName() +
                " " + villain.getCharacterClass().getName() +
                " " + villain.getLevel());

        System.out.println("Choose an action");
        int i = 0;
        System.out.println(i + 1 + ") Fight!");
        System.out.println(i + 2 + ") Try to avoid");
        System.out.println("I) Open equipment");
        String getPick = getSc().nextLine().toLowerCase();

        switch (getPick) {
            case "1":
                combatLoop = new CombatLoop(hero, villain);
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
}
