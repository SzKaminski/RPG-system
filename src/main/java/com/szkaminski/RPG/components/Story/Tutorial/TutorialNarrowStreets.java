package com.szkaminski.RPG.components.Story.Tutorial;

import com.szkaminski.RPG.Handlers.Observer;
import com.szkaminski.RPG.components.Story.Content;
import com.szkaminski.RPG.components.Story.Scenarios.Scenario;
import com.szkaminski.RPG.places.Place;
import com.szkaminski.RPG.places.village.NarrowStreets;
import com.szkaminski.RPG.places.world.OuterFields;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Image;

import java.util.ArrayList;
import java.util.List;

public class TutorialNarrowStreets extends Scenario {

    private Observer observer;

    private final String text1 = "The residential area is cut by a network of narrow streets full of intersections and alleys. In the years of prosperity, it was possible to get everything here, hardly available drugs, contraband, illegal goods, and a knife under ribs.";
    private Image image;
    private ArrayList<Component> components;
    private List<String> texts;

    private NarrowStreets narrowStreets;

    public TutorialNarrowStreets(Observer observer) {
        this.observer = observer;
        components = new ArrayList<>();
        texts = new ArrayList<>();
        narrowStreets = new NarrowStreets(observer);
    }

    public Place getLocation() {
        return narrowStreets;
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
        image = new Image("/images/narrowstreets.png", "streets");
        image.setClassName("imageContent");
        return image;
    }
}
