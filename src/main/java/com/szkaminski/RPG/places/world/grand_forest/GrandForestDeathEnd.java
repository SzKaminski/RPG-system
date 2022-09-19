package com.szkaminski.RPG.places.world.grand_forest;

import com.szkaminski.RPG.Handlers.Observer;
import com.szkaminski.RPG.components.Buttons.DirectionButton;
import com.szkaminski.RPG.places.Place;

import java.util.HashMap;
import java.util.Map;

public class GrandForestDeathEnd extends Place {

    private Observer observer;

    public GrandForestDeathEnd(Observer observer) {
        super("??????");
        this.observer = observer;
    }

    @Override
    public Map<String, DirectionButton> getDirections() {
        Map<String, DirectionButton> directions = new HashMap<>();
        DirectionButton direction_grandForestEdge = new DirectionButton(new GrandForestWilderness(observer));
        DirectionButton direction_grandForestWilderness1 = new DirectionButton(new GrandForestWilderness(observer));
        DirectionButton direction_grandForestWilderness2 = new DirectionButton(new GrandForestWilderness(observer));
        directions.put("???", direction_grandForestEdge);
        directions.put("S?", direction_grandForestWilderness1);
        directions.put("????", direction_grandForestWilderness2);

        return directions;
    }
}
