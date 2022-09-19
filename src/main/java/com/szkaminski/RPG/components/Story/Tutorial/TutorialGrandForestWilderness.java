package com.szkaminski.RPG.components.Story.Tutorial;

import com.szkaminski.RPG.Handlers.Observer;
import com.szkaminski.RPG.components.Story.Scenarios.Scenario;
import com.szkaminski.RPG.places.Place;
import com.szkaminski.RPG.places.world.grand_forest.GrandForestDepth;
import com.szkaminski.RPG.places.world.grand_forest.GrandForestWilderness;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Image;

import java.util.ArrayList;
import java.util.List;

public class TutorialGrandForestWilderness extends Scenario {
    private Observer observer;

    private final String text1 = "Forest Wilderness placeholder ";
    private Image image;
    private ArrayList<Component> components;
    private List<String> texts;
    private GrandForestWilderness grandForestWilderness;

    public TutorialGrandForestWilderness(Observer observer) {
        this.observer = observer;
        components = new ArrayList<>();
        texts = new ArrayList<>();
        grandForestWilderness = new GrandForestWilderness(observer);
    }

    public Place getLocation() {
        return grandForestWilderness;
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
        image = new Image("/images/grandForest.png", "first");
        image.setClassName("imageContent");
        return image;
    }
}
