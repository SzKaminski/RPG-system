package com.szkaminski.RPG.characters.characterEnums;

public enum Overall_health {

    FEELS_GOOD("Feels good"),
    INJURED("Injured"),
    HURT("Hurt"),
    ON_THE_VERGE_OF_DEATH("On the verge of death");

    private final String readableName;

    Overall_health(String readableName) {
        this.readableName = readableName;
    }

    public String getReadableName() {
        return readableName;
    }
}
