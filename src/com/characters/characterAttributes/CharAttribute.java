package com.characters.characterAttributes;

public abstract class CharAttribute {

    private String name;
    private String shortcut;
    private int value;

    public CharAttribute(String name, String shortcut, int value) {
        this.name = name;
        this.shortcut = shortcut;
        this.value = value;
    }

    public CharAttribute() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortcut() {
        return shortcut;
    }

    public void setShortcut(String shortcut) {
        this.shortcut = shortcut;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
