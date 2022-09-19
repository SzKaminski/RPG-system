package com.szkaminski.RPG.places.outskirts;

import com.szkaminski.RPG.Handlers.Observer;
import com.szkaminski.RPG.components.Buttons.DirectionButton;
import com.szkaminski.RPG.places.Place;
import com.szkaminski.RPG.places.world.Gorge;
import com.szkaminski.RPG.places.world.grand_forest.GrandForestEdge;

import java.util.HashMap;
import java.util.Map;

public class ForestCamp extends Place {

    private final String DESCRIPTION = "Hunters Camp placeholder description";
    private Observer observer;

    public ForestCamp(Observer observer) {
        super("Forest Camp");
        this.observer = observer;
    }

    @Override
    public Map<String, DirectionButton> getDirections() {
        Map<String, DirectionButton> directions = new HashMap<>();
        DirectionButton gorge_direction = new DirectionButton(new Gorge(observer));
        DirectionButton grandForestEdge_direction = new DirectionButton(new GrandForestEdge(observer));
        directions.put("N↥", gorge_direction);
        directions.put("W↤", grandForestEdge_direction);
        grandForestEdge_direction.addClickListener(event -> {
            observer.grandForestEdge_entry();
        });
        return directions;
    }
}
