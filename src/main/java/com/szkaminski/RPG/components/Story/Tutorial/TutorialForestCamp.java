package com.szkaminski.RPG.components.Story.Tutorial;

import com.szkaminski.RPG.Handlers.Observer;
import com.szkaminski.RPG.components.Story.Scenarios.Scenario;
import com.szkaminski.RPG.places.Place;
import com.szkaminski.RPG.places.outskirts.ForestCamp;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Image;

import java.util.ArrayList;
import java.util.List;

public class TutorialForestCamp extends Scenario {

    public TutorialForestCamp(Observer observer) {
        this.observer = observer;
        components = new ArrayList<>();
        texts = new ArrayList<>();
        forestCamp = new ForestCamp(observer);
    }

    private Observer observer;

    private final String text1 = "Tutorial Forest Camp placeholder ";
    private Image image;
    private ArrayList<Component> components;
    private List<String> texts;
    private ForestCamp forestCamp;

    public Place getLocation() {
        return forestCamp;
    }

    public List<String> getContentDescriptionList() {
        texts.add(text1);
        return texts;
    }

    public List<Component> getActionComponents() {
      /*  ActionButton merchant = new ActionButton("Nate Ganray - shopkeeper");
        components.add(merchant);
        //  Label choose_label = new MainLabel("Choose: ");
        // components.add(choose_label);
        // components.add(huntersCamp);Dw

        merchant.addClickListener(event -> {
            observer.meet_nate_genray();
        });*/
        return components;
    }

    @Override
    public Image getImage() {
        image = new Image("/images/forestedge.png", "first");
        image.setClassName("imageContent");
        return image;
    }
}
