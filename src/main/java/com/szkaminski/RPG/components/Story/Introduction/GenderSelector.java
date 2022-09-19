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

public class GenderSelector extends Scenario {

    private final String text = ContentList.getDialog().get("start_1");
    private Image image;
    private ArrayList<Component> components;
    private List<String> texts;
    private Observer observer;

    public GenderSelector(Observer observer) {
        super();
        components = new ArrayList<>();
        texts = new ArrayList<>();
        this.observer = observer;
        setVisible(true);
    }

    public Place getLocation() {
        return null;
    }

    public List<String> getContentDescriptionList() {
        texts.add(text);
        return texts;
    }


    public List<Component> getActionComponents() {
        ActionButton man_selected = new ActionButton("Man");
        ActionButton women_selected = new ActionButton("Women");

        Label choose_gender = new MainLabel("Choose: ");
        components.add(choose_gender);
        components.add(man_selected);
        components.add(women_selected);

        man_selected.addClickListener(event -> {
            observer.clicked_m();
        });
        women_selected.addClickListener(event -> {
            observer.clicked_w();
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
