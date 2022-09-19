package com.szkaminski.RPG.components.Functions;

import com.szkaminski.RPG.characters.Hero;
import com.szkaminski.RPG.components.MainLabel;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class Inventory extends Div {

    public Inventory(Hero hero) {
        this.setClassName("statistics-div");
        VerticalLayout vL = new VerticalLayout();
        if (hero != null) {
            vL.add(new MainLabel("Bandage"));
            vL.add(new MainLabel("Small food ration"));
            add(vL);
        }

        setVisible(false);
    }
}
