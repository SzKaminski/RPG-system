package com.szkaminski.RPG.places.village;

import com.szkaminski.RPG.Handlers.Observer;
import com.szkaminski.RPG.components.Buttons.DirectionButton;
import com.szkaminski.RPG.places.Place;
import com.szkaminski.RPG.places.world.OuterFields;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SouthGate extends Place {

    private final String DESCRIPTION = "South Gate placeholder description";
    private Observer observer;

    public SouthGate(Observer observer) {
        super("South Gate");
        this.observer = observer;
    }

    //↥↦↧↤
    @Override
    public Map<String, DirectionButton> getDirections() {
        Map<String, DirectionButton> directions = new HashMap<>();
        DirectionButton direction_marketPlace = new DirectionButton(new MarketPlace(observer));
        DirectionButton direction_outerFields = new DirectionButton(new OuterFields(observer));
        directions.put("N↥", direction_marketPlace);
        directions.put("S↧", direction_outerFields);
        direction_marketPlace.addClickListener(event -> {
           observer.marketplace_entry();
        });
        direction_outerFields.addClickListener(event -> {
            observer.outerFields_entry();
        });
        return directions;
    }
}