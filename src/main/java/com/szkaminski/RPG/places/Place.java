package com.szkaminski.RPG.places;

import com.szkaminski.RPG.components.Buttons.DirectionButton;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public abstract class Place {

    private String name;
    private String description;
    private Map<String, DirectionButton> directions;
    private List<Character> targets;
    //todo: private Object event;
    private Scanner sc;

    public Place(String name) {
        this.name = name;
        sc = new Scanner(System.in);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Character> getTargets() {
        return targets;
    }

    public Map<String, DirectionButton> getDirections() {
        return directions;
    }

    public void setDirections(Map<String, DirectionButton> directions) {
        this.directions = directions;
    }

    public void setTargets(List<Character> targets) {
        this.targets = targets;
    }
}
