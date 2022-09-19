package com.szkaminski.RPG.Handlers;

import com.szkaminski.RPG.components.Functions.Inventory;
import com.szkaminski.RPG.components.Functions.Journal;
import com.szkaminski.RPG.components.Functions.Statistics;
import com.szkaminski.RPG.components.Buttons.MainButton;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;

public class ButtonsMap extends Div {

    //todo: refactoring

    public ButtonsMap(Statistics statistics, Inventory inventory, Journal journal) {
        Button playerStats = new MainButton("Stats");
        playerStats.addClickListener(event -> {
            if (statistics.isVisible()){
                statistics.setVisible(false);

                journal.setVisible(false);
                inventory.setVisible(false);
            }else {
                statistics.setVisible(true);
                inventory.setVisible(false);

                journal.setVisible(false);
            }
        });

        Button playerJournal = new MainButton("Journal");
        playerJournal.addClickListener(event -> {
            if (journal.isVisible()){
                inventory.setVisible(false);
                statistics.setVisible(false);
                journal.setVisible(false);
            }else {
                journal.setVisible(true);
                inventory.setVisible(false);
                statistics.setVisible(false);
            }
        });
        Button playerIventory = new MainButton("Inventory");

        playerIventory.addClickListener(event -> {
            if (inventory.isVisible()){
                inventory.setVisible(false);
                journal.setVisible(false);
                inventory.setVisible(false);
                statistics.setVisible(false);
            }else {

                journal.setVisible(false);
                inventory.setVisible(true);
                statistics.setVisible(false);
            }
        });

        Button map = new MainButton("Map");
        this.setClassName("player-div");
        add(playerStats,playerJournal,playerIventory,map);
    }
}
