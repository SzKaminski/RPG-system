package com.places.Village;


import com.characters.Character;
import com.characters.Hero;
import com.characters.npcs.Merchant;
import com.places.World.OuterFields;
import com.places.Place;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.visuals.PauseEffect.pause;

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
        directions.put("S", new OuterFields());
        return directions;
    }

    @Override
    public void enter(Hero hero) {
        super.enter(hero);
        String getPick = getSc().nextLine().toLowerCase();

        if (this.isDigit(getPick))
            switch (getPick) {
                case "1":
                    getTargets().get(0).getConversation(hero);
                    pause();
                    enter(hero);
                    break;
                default:
                    enter(hero);
                    break;
            }
        else {
            setLocationDirections(hero, getPick, new NarrowStreets(), null, new OuterFields(), null);
        }
    }

}
