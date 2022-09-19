package com.szkaminski.RPG.components.Story.Introduction;

import com.szkaminski.RPG.Handlers.Observer;
import com.szkaminski.RPG.components.Buttons.ActionButton;
import com.szkaminski.RPG.components.MainLabel;
import com.szkaminski.RPG.components.Story.ContentList;
import com.szkaminski.RPG.components.Story.Scenarios.Scenario;
import com.szkaminski.RPG.places.Place;
import com.szkaminski.RPG.places.outskirts.ForestCamp;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;

import java.util.ArrayList;
import java.util.List;

public class ProvenanceSelector extends Scenario {

    private Observer observer;

    private final String text1 = ContentList.getDialog().get("start_4");
    private Image image;
    private ArrayList<Component> components;
    private List<String> texts;

    public ProvenanceSelector(Observer observer) {
        this.observer = observer;
        components = new ArrayList<>();
        texts = new ArrayList<>();
    }

    public Place getLocation() {
        return null;
    }

    public List<String> getContentDescriptionList() {
        texts.add(text1);
        return texts;
    }

    public List<Component> getActionComponents() {
        ActionButton huntersCamp = new ActionButton(new ForestCamp(observer).getName());
        ActionButton farm = new ActionButton("Farm");
        ActionButton monastery = new ActionButton("Monastery");
        ActionButton poverty = new ActionButton("Poverty");

        Label choose_label = new MainLabel("Choose: ");
        components.add(choose_label);
        components.add(huntersCamp);
        components.add(farm);
        components.add(monastery);
        components.add(poverty);

        huntersCamp.addClickListener(event -> {
            observer.selecting_huntersCamp();
        });
        farm.addClickListener(event -> {
            observer.selecting_farm();
        });
        return components;
    }

    @Override
    public Image getImage() {
        image = new Image("/images/first.png", "first");
        image.setClassName("imageContent");
        return image;
    }
}
