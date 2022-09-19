package com.szkaminski.RPG.components.Story.Introduction;

import com.szkaminski.RPG.Handlers.Observer;
import com.szkaminski.RPG.components.Buttons.ActionButton;
import com.szkaminski.RPG.components.Story.ContentList;
import com.szkaminski.RPG.components.Story.Scenarios.Scenario;
import com.szkaminski.RPG.places.Place;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Image;

import java.util.ArrayList;
import java.util.List;

public class EndOfIntroduction extends Scenario {


    private final String text = ContentList.getDialog().get("start_end");
    private Image image;
    private ArrayList<Component> components;
    private List<String> texts;
    private Observer observer;

    public EndOfIntroduction(Observer observer) {
        components = new ArrayList<>();
        texts = new ArrayList<>();
        this.observer = observer;
    }

    public Place getLocation() {
        return null;
    }

    public List<String> getContentDescriptionList() {
        texts.add(text);
        return texts;
    }


    public List<Component> getActionComponents() {
        ActionButton continueButton = new ActionButton("Continue");

        components.add(continueButton);
        continueButton.addClickListener(event -> {
            observer.marketplace_entry();
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
