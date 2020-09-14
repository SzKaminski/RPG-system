package com.places;


import com.characters.Character;
import com.characters.Hero;
import com.characters.npcs.Merchant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.visualeffects.PauseEffect.pause;

public class MarketPlace extends Place {

    private final String DESCRIPTION = "market place placeholder description";
    private List<Character> targets;

    public MarketPlace() {
        super("Market Place");
        setDescription(DESCRIPTION);
        targets = new ArrayList<>();
    }

    @Override
    public List<Character> getTargets() {
        targets = new ArrayList<>();
        targets.add(new Merchant());
        return targets;
    }

    @Override
    public Map<String, Place> getDirections() {
        Map<String, Place> directions = new HashMap<>();
        directions.put("N", new NarrowStreets());
        return directions;
    }

    @Override
    public void enter(Hero hero) {
        super.enter(hero);
        for (int i = 0; i < getTargets().size(); i++) {
            System.out.println(i + 1 + ") " + getTargets().get(i).getDescription() + " " + getTargets().get(i).getName());
        }
        Map<String, Place> directions = hero.getLocation().getDirections();

        for (Map.Entry<String, Place> entry : directions.entrySet()) {
            System.out.print(entry.getKey() + " : " + entry.getValue().getName() + " | ");
        }
        System.out.println("\nI : open inventory");

        String getPick = getSc().nextLine().toLowerCase();

        if (this.isDigit(getPick))
            switch (getPick) {
                case "1":
                    getTargets().get(0).getConversation();
                    pause();
                    enter(hero);
                    break;
            }
        else {
            setLocationDirections(hero, getPick);
        }
    }

    private void setLocationDirections(Hero hero, String getPick) {
        switch (getPick) {
            case "n":
                NarrowStreets narrowStreets = new NarrowStreets();
                hero.setLocation(narrowStreets);
                narrowStreets.enter(hero);
                break;
            case "e":
                break;
            case "s":
                break;
            case "w":
                break;
            case "i":
                hero.manageInventory();
                enter(hero);
                break;
            default:
                System.out.println("Wrong direction");
                enter(hero);
                break;
        }
    }


}
