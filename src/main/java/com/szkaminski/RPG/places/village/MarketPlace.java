package com.szkaminski.RPG.places.village;

import com.szkaminski.RPG.Handlers.Observer;
import com.szkaminski.RPG.components.Buttons.DirectionButton;
import com.szkaminski.RPG.places.Place;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MarketPlace extends Place{

    private final String DESCRIPTION = "market place placeholder description";
    private Observer observer;

    public MarketPlace(Observer observer) {
        super("Market Place");
        setDescription(DESCRIPTION);
        this.observer = observer;
    }


    //↥↦↧↤
    @Override
    public Map<String, DirectionButton> getDirections() {
        Map<String, DirectionButton> directions = new HashMap<>();
        DirectionButton narrowStreets_direction = new DirectionButton(new NarrowStreets(observer));
        DirectionButton southgate_direction = new DirectionButton(new SouthGate(observer));
        directions.put("N↥", narrowStreets_direction);
        directions.put("S↧", southgate_direction);

        southgate_direction.addClickListener(event -> {
           observer.southGate_entry();
        });

        narrowStreets_direction.addClickListener(event -> {
           observer.narrowStreets_entry();
        });
        return directions;
    }

}
