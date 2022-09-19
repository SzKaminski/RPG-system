package com.szkaminski.RPG.components.Buttons;

import com.szkaminski.RPG.places.Place;

public class DirectionButton extends MainButton {

    public DirectionButton(Place direction) {
        super(direction.getName());
        this.setClassName("direction_buttons");
    }
}
