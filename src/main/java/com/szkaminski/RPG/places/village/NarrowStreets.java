package com.szkaminski.RPG.places.village;

import com.szkaminski.RPG.Handlers.Observer;
import com.szkaminski.RPG.components.Buttons.DirectionButton;
import com.szkaminski.RPG.places.Place;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NarrowStreets extends Place {

    private final String DESCRIPTION = "narrow streets placeholder description";
    private List<Place> directions;
    private List<Object> targets;

    private Observer observer;

    public NarrowStreets(Observer observer) {
        super("Narrow Streets");

        this.observer = observer;
    }

    //↥↦↧↤
    @Override
    public Map<String, DirectionButton> getDirections() {
        Map<String, DirectionButton> directions = new HashMap<>();
        DirectionButton directionButton = new DirectionButton(new MarketPlace(observer));

        directions.put("S↧", directionButton);

        directionButton.addClickListener(event -> {
            observer.marketplace_entry();
        });
        return directions;
    }
}
