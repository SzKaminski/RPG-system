package com.szkaminski.RPG.components.Story.Tutorial;

import com.szkaminski.RPG.Handlers.Observer;
import com.szkaminski.RPG.components.Buttons.ActionButton;
import com.szkaminski.RPG.components.Story.Scenarios.Scenario;
import com.szkaminski.RPG.places.Place;
import com.szkaminski.RPG.places.village.MarketPlace;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Image;

import java.util.ArrayList;
import java.util.List;

public class TutorialMarketPlace extends Scenario {


    private Observer observer;

    private final String text1 = "This place used to be a bustling center of the surrounding trade. " +
            "Today there are only a few merchants here who are rather not expanding their offer. " +
            "Route between merchants stoods and city hall was cut by a well that had been closed for a long time.";
    private Image image;
    private ArrayList<Component> components;
    private List<String> texts;
    private MarketPlace marketPlace;

    public TutorialMarketPlace(Observer observer) {
        this.observer = observer;
        components = new ArrayList<>();
        texts = new ArrayList<>();
        marketPlace = new MarketPlace(observer);
    }

    public Place getLocation() {
        return marketPlace;
    }

    public List<String> getContentDescriptionList() {
        texts.add(text1);
        return texts;
    }

    public List<Component> getActionComponents() {
        ActionButton merchant = new ActionButton("Nate Ganray - shopkeeper");
        components.add(merchant);
        //  Label choose_label = new MainLabel("Choose: ");
        // components.add(choose_label);
        // components.add(huntersCamp);Dw

        merchant.addClickListener(event -> {
            observer.meet_nate_genray();
        });
        return components;
    }

    @Override
    public Image getImage() {
        image = new Image("/images/market.png", "market");
        image.setClassName("imageContent");
        return image;
    }
}
