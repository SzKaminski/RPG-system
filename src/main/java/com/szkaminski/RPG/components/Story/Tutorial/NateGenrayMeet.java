package com.szkaminski.RPG.components.Story.Tutorial;

import com.szkaminski.RPG.Handlers.Observer;
import com.szkaminski.RPG.components.Buttons.ActionButton;
import com.szkaminski.RPG.components.Story.Scenarios.Scenario;
import com.szkaminski.RPG.places.Place;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Image;

import java.util.ArrayList;
import java.util.List;

public class NateGenrayMeet extends Scenario {

    private Observer observer;

    private final String text1 = "Alderman approached old, gray-haired, hunched merchant. He was short, round-shouldered " +
            "and he wore richly decorated but dirty and damaged clothes. His yellow eyes quickly spotted the Alderman, " +
            "he was nearly blind but he could perfectly recognize a person by their shape. ";
    private Image image;
    private ArrayList<Component> components;
    private List<String> texts;

    public NateGenrayMeet(Observer observer) {
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
        ActionButton tradeButton = new ActionButton("I need some supplies.");
        ActionButton endOfConversation = new ActionButton("Bye.");

        components.add(tradeButton);
        components.add(endOfConversation);
        //  Label choose_label = new MainLabel("Choose: ");
        // components.add(choose_label);
        // components.add(huntersCamp);

        tradeButton.addClickListener(event -> {
            observer.meet_nate_genray();
        });
        endOfConversation.addClickListener(event -> {
            observer.marketplace_entry();
        });
        return components;
    }

    @Override
    public Image getImage() {
        image = new Image("/images/nate.png", "nate");
        image.setClassName("imageContent");
        return image;
    }
}
