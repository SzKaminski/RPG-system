package com.szkaminski.RPG.places.world.grand_forest;

import com.szkaminski.RPG.Handlers.Observer;
import com.szkaminski.RPG.components.Buttons.DirectionButton;
import com.szkaminski.RPG.places.Place;
import com.szkaminski.RPG.places.world.OuterFields;

import java.util.HashMap;
import java.util.Map;

public class GrandForestDepth extends Place {

    private Observer observer;

    public GrandForestDepth(Observer observer) {
        super("Grand Forest's depth");
        this.observer = observer;
    }

    @Override
    public Map<String, DirectionButton> getDirections() {
        Map<String, DirectionButton> directions = new HashMap<>();
        DirectionButton direction_grandForestEdge = new DirectionButton(new OuterFields(observer));
        DirectionButton direction_grandForestWilderness1 = new DirectionButton(new GrandForestEdge(observer));
        DirectionButton direction_grandForestWilderness2 = new DirectionButton(new GrandForestWilderness(observer));
        directions.put("N↥", direction_grandForestEdge);
        directions.put("S↧", direction_grandForestWilderness1);
        directions.put("W? or E?", direction_grandForestWilderness2);

        direction_grandForestEdge.addClickListener(event -> {
            observer.grandForestDepth_entry();
        });

        direction_grandForestWilderness1.addClickListener(event -> {
            observer.grandForestDepth_entry();
        });

        direction_grandForestWilderness2.addClickListener(event -> {
            observer.grandForestWilderness_entry();
        });
        return directions;
    }
}
