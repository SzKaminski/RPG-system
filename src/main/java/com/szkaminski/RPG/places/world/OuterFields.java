package com.szkaminski.RPG.places.world;

import com.szkaminski.RPG.Handlers.Observer;
import com.szkaminski.RPG.components.Buttons.DirectionButton;
import com.szkaminski.RPG.places.Place;
import com.szkaminski.RPG.places.village.SouthGate;
import com.szkaminski.RPG.places.world.grand_forest.GrandForestEdge;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OuterFields extends Place {

    private Observer observer;

    private final String DESCRIPTION = "Outher fields placeholder description";
    // private List<Place> directions;
    private List<Character> targets;
    private Map<String, DirectionButton> directions;

    public OuterFields(Observer observer) {
        super("Outer Fields");
        this.observer = observer;
        this.directions = new HashMap<>();

    }

    //↥↦↧↤
    @Override
    public Map<String, DirectionButton> getDirections() {
        DirectionButton direction_southGate = new DirectionButton(new SouthGate(observer));
        DirectionButton direction_grandForest = new DirectionButton(new GrandForestEdge(observer));
        DirectionButton direction_farms = new DirectionButton(new Farms(observer));
        DirectionButton direction_gorge = new DirectionButton(new Gorge(observer));
        directions.put("N↥", direction_southGate);
        directions.put("S↧", direction_grandForest);
        directions.put("W↤", direction_farms);
        directions.put("E↦", direction_gorge);

        direction_southGate.addClickListener(event -> {
            observer.southGate_entry();
        });

        direction_grandForest.addClickListener(event -> {
            observer.grandForestEdge_entry();
        });
        return directions;
    }

    public Place getTutorialVariant() {
        DirectionButton direction_southGate = new DirectionButton(new SouthGate(observer));
        DirectionButton direction_grandForest = new DirectionButton(new GrandForestEdge(observer));
        directions.put("N↥", direction_southGate);
        directions.put("S↧", direction_grandForest);
        direction_southGate.addClickListener(event -> {
            observer.southGate_entry();
        });

        direction_grandForest.addClickListener(event -> {
            observer.grandForestEdge_entry();
        });
        return this;
    }
}

/*public class OuterFields extends Place {

    private Observer observer;

    public OuterFields(Observer observer) {
        super();
        this.observer = observer;
    }
}*/
