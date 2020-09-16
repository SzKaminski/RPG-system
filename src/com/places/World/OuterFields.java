package com.places.World;

import com.characters.Hero;
import com.places.Place;
import com.places.Village.MarketPlace;

import java.util.HashMap;
import java.util.Map;

import static com.visuals.PauseEffect.pause;

public class OuterFields extends Place {

    private final String DESCRIPTION = "Outer Fields placeholder description";

    public OuterFields() {
        super("Outer Fields");
        setDescription(DESCRIPTION);
    }

    @Override
    public void enter(Hero hero) {
        super.enter(hero);
        String getPick = getSc().nextLine().toLowerCase();

        if (isDigit(getPick))
            switch (getPick) {
                case "1":
                    //  getTargets().get(0).getConversation();
                    pause();
                    enter(hero);
                    break;
                default:
                    enter(hero);
                    break;
            }
        else
            setLocationDirections(hero, getPick, new MarketPlace(), null, null, null);
    }

    @Override
    public Map<String, Place> getDirections() {
        Map<String, Place> directions = new HashMap<>();
        directions.put("N", new MarketPlace());
        return directions;
    }
}
