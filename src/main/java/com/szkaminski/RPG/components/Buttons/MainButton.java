package com.szkaminski.RPG.components.Buttons;

import com.vaadin.flow.component.button.Button;

public class MainButton extends Button {

    public MainButton() {

    }

    public MainButton(String text) {
        super(text);
        this.setClassName("buttons");
    }

}
