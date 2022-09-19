package com.szkaminski.RPG.components.Story.Introduction;

import com.szkaminski.RPG.Handlers.Observer;
import com.szkaminski.RPG.components.Buttons.ActionButton;
import com.szkaminski.RPG.components.Buttons.ActionField;
import com.szkaminski.RPG.components.MainLabel;
import com.szkaminski.RPG.components.Story.ContentList;
import com.szkaminski.RPG.components.Story.Scenarios.Scenario;
import com.szkaminski.RPG.places.Place;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyDownEvent;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;

import java.util.ArrayList;
import java.util.List;

public class NameSelector extends Scenario {

    private final String text1 = ContentList.getDialog().get("start_2");
    private final String text2 = ContentList.getDialog().get("start_3a");
    private Image image;
    private ArrayList<Component> components;
    private List<String> texts;
    private Observer observer;

    public NameSelector(Observer observer) {
        components = new ArrayList<>();
        texts = new ArrayList<>();
        this.observer = observer;
    }

    public Place getLocation() {
        return null;
    }

    public List<String> getContentDescriptionList() {
        texts.add(text1);
        texts.add(text2);
        return texts;
    }


    public List<Component> getActionComponents() {
        Label choose_name = new MainLabel("Type name: ");
        ActionField actionField = new ActionField("");
        ActionButton continueButton = new ActionButton("Continue");
        components.add(choose_name);
        components.add(actionField);
        components.add(continueButton);

        actionField.addKeyDownListener(Key.ENTER, (ComponentEventListener<KeyDownEvent>) keyDownEvent -> {
            observer.selecting_name(actionField.getValue());
            String name = actionField.getValue();
            //actions_panel.add(new MainLabel(" ... " + name), continue_button);
        });
        actionField.addValueChangeListener(e -> {
            continueButton.addClickListener(event -> {
                observer.selecting_name(actionField.getValue());
            });
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
