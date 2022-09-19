package com.szkaminski.RPG.components.Story.Tutorial;

import com.szkaminski.RPG.Handlers.Observer;
import com.szkaminski.RPG.components.Buttons.ActionButton;
import com.szkaminski.RPG.components.Story.Scenarios.Scenario;
import com.szkaminski.RPG.places.Place;
import com.szkaminski.RPG.places.village.MarketPlace;
import com.szkaminski.RPG.places.village.SouthGate;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Image;

import java.util.ArrayList;
import java.util.List;

public class TutorialSouthGate extends Scenario {

    private Observer observer;

    private final String text1 = "The largest of the three city gates of <city_name>. " +
            "It was built in the face of the threat of the Great Migration years. " +
            "The complex consisted of two high towers connected by a heavy lowered wooden and brass grate. " +
            "From the gate, the view stretches over the road leading to the Great Forest and the nearby buildings of the Poverty District. " +
            "At the gate, behind the table, sat a middle-aged man, his appearance showing that he belonged to the city guard.";
    private Image image;
    private ArrayList<Component> components;
    private List<String> texts;
    private SouthGate southGate;

    public TutorialSouthGate(Observer observer) {
        this.observer = observer;
        components = new ArrayList<>();
        texts = new ArrayList<>();
        southGate = new SouthGate(observer);
    }

    public Place getLocation() {
        return southGate;
    }

    public List<String> getContentDescriptionList() {
        texts.add(text1);
        return texts;
    }

    public List<Component> getActionComponents() {
        ActionButton guard = new ActionButton("Tork Ruslan - gate guard");
        components.add(guard);
        //  Label choose_label = new MainLabel("Choose: ");
        // components.add(choose_label);
        // components.add(huntersCamp);Dw

        guard.addClickListener(event -> {
            observer.meet_southgate_guard();
        });
        return components;
    }

    @Override
    public Image getImage() {
        image = new Image("/images/southgate.png", "first");
        image.setClassName("imageContent");
        return image;
    }

}
