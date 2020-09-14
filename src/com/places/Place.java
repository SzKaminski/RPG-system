package com.places;

import com.characters.Character;
import com.characters.Hero;
import com.visualeffects.Printer;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static com.visualeffects.Printer.println;

public abstract class Place {

    private String name;
    private String description;
    private Map<String,Place> directions;
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

    public Map<String, Place> getDirections() {
        return directions;
    }

    public void setDirections(Map<String, Place> directions) {
        this.directions = directions;
    }

    public void setTargets(List<Character> targets) {
        this.targets = targets;
    }

    public void enter(Hero hero){
        println(hero.getName()+ " enters " + this.getName(), Printer.PrinterColor.COLOR_RED);
        println(hero.getLocation().getName() + "| the sun is at its zenith |" + " K 2, 2231", Printer.PrinterColor.COLOR_BLUE);
        println(hero.getLocation().getDescription(), Printer.PrinterColor.COLOR_GREEN);

    };

    public Scanner getSc() {
        return sc;
    }

    boolean isDigit(String dig) {
        try {
            Integer.parseInt(dig);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
