package com.szkaminski.RPG.components.Story.Introduction;

import com.szkaminski.RPG.Handlers.Observer;
import com.szkaminski.RPG.components.Buttons.ActionButton;
import com.szkaminski.RPG.components.MainLabel;
import com.szkaminski.RPG.components.Story.ContentList;
import com.szkaminski.RPG.components.Story.Scenarios.Scenario;
import com.szkaminski.RPG.places.Place;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;

import java.util.ArrayList;
import java.util.List;

public class ClassSelector extends Scenario {

    private final String text1 = ContentList.getDialog().get("start_5");
    private final String text2 = ContentList.getDialog().get("start_6b");


    private Image image;
    private ArrayList<Component> components;
    private List<String> texts;
    private Observer observer;

    public ClassSelector(Observer observer) {
        components = new ArrayList<>();
        texts = new ArrayList<>();
        this.observer = observer;
    }

    public Place getLocation() {
        return null;
    }

    public List<String> getContentDescriptionList() {
        texts.add(text1 + " " + observer.getPlace() + "?");
        //texts.add();
        texts.add(text2);
        return texts;
    }

    public List<Component> getActionComponents() {

        ActionButton young_thin = new ActionButton("young and thin");
        ActionButton muscle = new ActionButton("tall with huge muscles");
        ActionButton old_secret = new ActionButton("old and mysterious");

        Label choose_label = new MainLabel("Choose: ");
        components.add(choose_label);
        components.add(young_thin);
        components.add(muscle);
        components.add(old_secret);

        young_thin.addClickListener(event -> {
            observer.selecting_young();
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
