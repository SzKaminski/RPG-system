package com.szkaminski.RPG.places.world.grand_forest;

import com.szkaminski.RPG.Handlers.Observer;
import com.szkaminski.RPG.components.Buttons.DirectionButton;
import com.szkaminski.RPG.places.Place;
import com.szkaminski.RPG.places.outskirts.ForestCamp;
import com.szkaminski.RPG.places.world.OuterFields;

import java.util.HashMap;
import java.util.Map;

public class GrandForestEdge extends Place {

    private Observer observer;

    public GrandForestEdge(Observer observer) {
        super("Grand Forest's edge");
        this.observer = observer;
    }

    @Override
    public Map<String, DirectionButton> getDirections() {
        Map<String, DirectionButton> directions = new HashMap<>();
        DirectionButton direction_outherFields = new DirectionButton(new OuterFields(observer));
        DirectionButton direction_grandForest = new DirectionButton(new GrandForestDepth(observer));
        DirectionButton direction_forestCamp = new DirectionButton(new ForestCamp(observer));
        directions.put("N↥", direction_outherFields);
        directions.put("S↧", direction_grandForest);
        directions.put("E↦", direction_forestCamp);

        direction_outherFields.addClickListener(event -> {
            observer.outerFields_entry();
        });

        direction_forestCamp.addClickListener(event -> {
            observer.forestCamp_entry();
        });

        direction_grandForest.addClickListener(event -> {
           observer.grandForestDepth_entry();
        });
        return directions;
    }
}
