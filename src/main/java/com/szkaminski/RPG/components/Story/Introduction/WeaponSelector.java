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

public class WeaponSelector extends Scenario {

    private final String text1 = ContentList.getDialog().get("start_7a");

    private Image image;
    private ArrayList<Component> components;
    private List<String> texts;
    private Observer observer;

    public WeaponSelector(Observer observer) {
        components = new ArrayList<>();
        texts = new ArrayList<>();
        this.observer = observer;
    }

    public Place getLocation() {
        return null;
    }

    public List<String> getContentDescriptionList() {
        texts.add(text1);
        return texts;
    }

    public List<Component> getActionComponents() {

        ActionButton sword = new ActionButton("an ancestral sword");
        ActionButton knife = new ActionButton("a short knife");
        ActionButton staff = new ActionButton("an old's man staff");

        Label choose_label = new MainLabel("Choose: ");
        components.add(choose_label);
        components.add(sword);
        components.add(knife);
        components.add(staff);

        sword.addClickListener(event -> {
            observer.selecting_sword();
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
