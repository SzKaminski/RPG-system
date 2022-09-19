package com.szkaminski.RPG.characters;

import com.szkaminski.RPG.characters.characterEnums.Overall_health;
import com.szkaminski.RPG.components.Functions.Statistics;

public class Hero extends Character {

    private Overall_health overall_health;

    public Hero() {
    }

    public Overall_health getOverall_health() {
        return overall_health;
    }

    public void setOverall_health(Overall_health overall_health) {
        this.overall_health = overall_health;
    }

    public Statistics getStatistics() {
        return null;
    }
}
