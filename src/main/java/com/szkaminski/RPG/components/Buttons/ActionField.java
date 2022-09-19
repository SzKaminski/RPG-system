package com.szkaminski.RPG.components.Buttons;

import com.vaadin.flow.component.textfield.TextField;

public class ActionField extends TextField {

    public ActionField(String label) {
        super(label);
        this.setClassName("action-field");
    }

    public ActionField(String label, String initialValue, String placeholder) {
        super(label, initialValue, placeholder);

        this.setClassName("action-field");
    }
}
