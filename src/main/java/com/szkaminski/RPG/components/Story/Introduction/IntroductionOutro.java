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

public class IntroductionOutro extends Scenario {

    private final String text1 = ContentList.getDialog().get("start_8");
    private Image image;
    private ArrayList<Component> components;
    private List<String> texts;
    private Observer observer;

    public IntroductionOutro(Observer observer) {
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
        ActionButton continueButton = new ActionButton("Continue");

        components.add(continueButton);
        continueButton.addClickListener(event -> {
            observer.first_dialog_end();
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
