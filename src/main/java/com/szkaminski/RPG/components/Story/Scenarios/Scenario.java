package com.szkaminski.RPG.components.Story.Scenarios;

import com.szkaminski.RPG.places.Place;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;

import java.util.List;

public class Scenario extends Div  {

    private Place location; //todo: location's directions / location name to the top
    private List<String> contentDescription;
    private Image image;

    private List<Component> actionComponents;

    public Scenario() {
    }

    public Scenario(Place location, List<String> contentDescription, List<Component> actionComponents) {
        this.location = location;
        this.contentDescription = contentDescription;
        this.actionComponents = actionComponents;
    }

    public Place getLocation() {
        return location;
    }

    public void setLocation(Place location) {
        this.location = location;
    }

    public List<String> getContentDescriptionList() {
        return contentDescription;
    }

    public List<Component> getActionComponents() {
        return actionComponents;
    }

    public void setActionComponents(List<Component> actionComponents) {
        this.actionComponents = actionComponents;
    }

    public Image getImage() {
        return image;
    }

}
