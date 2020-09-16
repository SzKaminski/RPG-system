package com.places;

import com.characters.Character;
import com.characters.Hero;
import com.visuals.Printer;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static com.visuals.Printer.println;

public abstract class Place {

    private String name;
    private String description;
    private Map<String, Place> directions;
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

    public void enter(Hero hero) {
        Place heroLocation = hero.getLocation();

        println(heroLocation.getName() + "| the sun is at its zenith |" + " K 2, 2231", Printer.PrinterColor.COLOR_BLUE);
        println(heroLocation.getDescription(), Printer.PrinterColor.COLOR_GREEN);

        directions = heroLocation.getDirections();

        for (Map.Entry<String, Place> entry : directions.entrySet()) {
            System.out.print(entry.getKey() + " : " + entry.getValue().getName() + " | ");
        }
        System.out.println("\nI : open inventory");
        System.out.println();
        if (getTargets() != null) {
            for (int i = 0; i < getTargets().size(); i++) {
                if (getTargets().get(i).getDescription() != null) {
                    System.out.println(i + 1 + ") " + getTargets().get(i).getDescription() + " " + getTargets().get(i).getName());
                } else {
                    System.out.println(i + 1 + ") " + getTargets().get(i).getName());
                }
            }
        }
    }

    public Scanner getSc() {
        return sc;
    }

    public boolean isDigit(String dig) {
        try {
            Integer.parseInt(dig);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void setLocationDirections(Hero hero, String getPick, Place northPlace, Place eastPlace, Place southPlace, Place westPlace) {
        switch (getPick) {
            case "n":
                if (northPlace != null) {
                    hero.setLocation(northPlace);
                    println(hero.getName() + " enters " + northPlace.getName(), Printer.PrinterColor.COLOR_RED);
                    northPlace.enter(hero);
                } else
                    System.out.println("There is no way to get there");
                    enter(hero);
                break;
            case "e":
                if (eastPlace != null) {
                    hero.setLocation(eastPlace);
                    println(hero.getName() + " enters " + eastPlace.getName(), Printer.PrinterColor.COLOR_RED);
                    eastPlace.enter(hero);
                } else
                    System.out.println("There is no way to get there");
                    enter(hero);
                break;
            case "s":
                if (southPlace != null) {
                    hero.setLocation(southPlace);
                    println(hero.getName() + " enters " + southPlace.getName(), Printer.PrinterColor.COLOR_RED);
                    southPlace.enter(hero);
                } else
                    System.out.println("There is no way to get there");
                    enter(hero);
                break;
            case "w":
                if (westPlace != null) {
                    hero.setLocation(westPlace);
                    println(hero.getName() + " enters " + westPlace.getName(), Printer.PrinterColor.COLOR_RED);
                    westPlace.enter(hero);
                } else
                    System.out.println("There is no way to get there");
                    enter(hero);
                break;
            case "i":
                hero.manageInventory();
                enter(hero);
                break;
            default:
                enter(hero);
                break;
        }
    }
}
