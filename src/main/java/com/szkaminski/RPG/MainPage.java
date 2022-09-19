package com.szkaminski.RPG;

import com.szkaminski.RPG.characters.Hero;
import com.szkaminski.RPG.characters.rpcs.Alderman;
import com.szkaminski.RPG.components.Story.Content;
import com.szkaminski.RPG.Handlers.ButtonsMap;
import com.szkaminski.RPG.components.Functions.Inventory;
import com.szkaminski.RPG.components.Functions.Journal;
import com.szkaminski.RPG.components.Functions.Statistics;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;

@HtmlImport("frontend://styles/shared-styles.html")
@Route(value = "")
public class MainPage extends HorizontalLayout {

    private ButtonsMap buttonsMap;
    private Statistics statistics;
    private Inventory inventory;
    private Journal journal;
    private Hero hero;
    public MainPage() {

        hero = new Alderman();
        Content mainContent = new Content();
        statistics = new Statistics(hero);
        inventory = new Inventory(hero);
        journal = new Journal(hero);

        buttonsMap = new ButtonsMap(statistics,inventory, journal);
        Div parchment = new Div();
        parchment.setId("parchment");
        parchment.add(mainContent, buttonsMap, statistics,inventory, journal);

        add(parchment);
    }
}
