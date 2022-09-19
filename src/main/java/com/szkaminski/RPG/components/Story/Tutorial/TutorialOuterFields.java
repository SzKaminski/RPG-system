package com.szkaminski.RPG.components.Story.Tutorial;

import com.szkaminski.RPG.Handlers.Observer;
import com.szkaminski.RPG.components.Buttons.ActionButton;
import com.szkaminski.RPG.components.Story.Content;
import com.szkaminski.RPG.components.Story.Scenarios.Scenario;
import com.szkaminski.RPG.places.Place;
import com.szkaminski.RPG.places.village.MarketPlace;
import com.szkaminski.RPG.places.world.OuterFields;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Image;

import java.util.ArrayList;
import java.util.List;

public class TutorialOuterFields extends Scenario {

    private Observer observer;

    private final String text1 = "Outherfields placeholder description ";
    private Image image;
    private ArrayList<Component> components;
    private List<String> texts;

    private OuterFields outerFields;

    public TutorialOuterFields(Observer observer) {
        this.observer = observer;
        components = new ArrayList<>();
        texts = new ArrayList<>();
        outerFields = new OuterFields(observer);
    }

    public Place getLocation() {
        return outerFields.getTutorialVariant();
    }

    public List<String> getContentDescriptionList() {
        texts.add(text1);
        return texts;
    }

    public List<Component> getActionComponents() {

        return components;
    }

    @Override
    public Image getImage() {
        image = new Image("/images/southgate.png", "first");
        image.setClassName("imageContent");
        return image;
    }
}
