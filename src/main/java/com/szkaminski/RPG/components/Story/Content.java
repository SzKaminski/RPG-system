package com.szkaminski.RPG.components.Story;

import com.szkaminski.RPG.Handlers.Observer;
import com.szkaminski.RPG.builders.HeroBuilder;
import com.szkaminski.RPG.characters.characterEnums.Gender;
import com.szkaminski.RPG.characters.characterEnums.Weapon;
import com.szkaminski.RPG.components.Buttons.DirectionButton;
import com.szkaminski.RPG.components.MainLabel;
import com.szkaminski.RPG.components.Story.Introduction.*;
import com.szkaminski.RPG.components.Story.Scenarios.Scenario;
import com.szkaminski.RPG.components.Story.Tutorial.*;
import com.szkaminski.RPG.places.outskirts.ForestCamp;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.Map;

public class Content extends VerticalLayout implements Observer {

    private Observer observer;
    private HeroBuilder characterCreator;
    private NameSelector nameSelector;
    private ProvenanceSelector provenanceSelector;
    private ClassSelector classSelector;
    private WeaponSelector weaponSelector;
    private TutorialMarketPlace tutorialMarketPlace;
    private IntroductionOutro introductionOutro;
    private EndOfIntroduction endOfIntroduction;
    private NateGenrayMeet nateGenrayMeet;
    private TutorialSouthGate tutorialSouthGate;
    private TutorialOuterFields tutorialOuterFields;
    private TutorialGrandForestEdge tutorialGrandForestEdge;
    private TutorialForestCamp tutorialForestCamp;
    private TutorialGreatForestDepth tutorialGreatForestDepth;
    private TutorialGrandForestWilderness tutorialGrandForestWilderness;
    private TutorialGrandForestDeathEnd tutorialGrandForestDeathEnd;
    private TutorialNarrowStreets tutorialNarrowStreets;

    public Content() {
        this.setClassName("content");
        characterCreator = new HeroBuilder();

        // creating instances of Introduction scenarios in the content
        Scenario genderSelector = new GenderSelector(this);
        this.nameSelector = new NameSelector(this);
        this.provenanceSelector = new ProvenanceSelector(this);
        this.classSelector = new ClassSelector(this);
        this.weaponSelector = new WeaponSelector(this);
        this.tutorialMarketPlace = new TutorialMarketPlace(this);
        this.introductionOutro = new IntroductionOutro(this);
        this.endOfIntroduction = new EndOfIntroduction(this);
        this.nateGenrayMeet = new NateGenrayMeet(this);
        this.tutorialSouthGate = new TutorialSouthGate(this);
        this.tutorialOuterFields = new TutorialOuterFields(this);
        this.tutorialGrandForestEdge = new TutorialGrandForestEdge(this);
        this.tutorialForestCamp = new TutorialForestCamp(this);
        this.tutorialGreatForestDepth = new TutorialGreatForestDepth(this);
        this.tutorialGrandForestWilderness = new TutorialGrandForestWilderness(this);
        this.tutorialGrandForestDeathEnd = new TutorialGrandForestDeathEnd(this);
        this.tutorialNarrowStreets = new TutorialNarrowStreets(this);

        //getLoop(genderSelector);

        getLoop(tutorialMarketPlace);

    }

    private void getLoop(Scenario scenario) {
        removeAll();
        scenario.getActionComponents().clear();
        scenario.getContentDescriptionList().clear();

        HorizontalLayout actions_panel = new HorizontalLayout();
        actions_panel.setClassName("horizontal-action");

        Scenario active_scenario = new Scenario(scenario.getLocation(),
                scenario.getContentDescriptionList(),
                scenario.getActionComponents()
        );
        if (active_scenario.getLocation() != null) {
            add(new MainLabel(active_scenario.getLocation().getName()));
        }

        // page structure
        for (int i = 0; i < active_scenario.getContentDescriptionList().size(); i++) {
            add(new MainLabel(active_scenario.getContentDescriptionList().get(i)));
        }

        for (int i = 0; i < active_scenario.getActionComponents().size(); i++) {
            actions_panel.add(active_scenario.getActionComponents().get(i));
            add(actions_panel);
        }

        if (active_scenario.getLocation() != null){
            Map<String, DirectionButton> directions = active_scenario.getLocation().getDirections();
            HorizontalLayout directions_layout = new HorizontalLayout();
            directions_layout.addClassName("horizontal-action");
            add(new MainLabel("Directions: "));
            for ( Map.Entry<String, DirectionButton> entry : directions.entrySet()) {
                String direction = entry.getKey();
                MainLabel direction_sign = new MainLabel(direction);
                direction_sign.setClassName("direction-sign");
                directions_layout.add(direction_sign);
                DirectionButton name = entry.getValue();
                directions_layout.add(name);
            }
            add(directions_layout);
        }
        add(scenario.getImage());
    }


    @Override
    public void clicked_m() {
        characterCreator.withGender(Gender.MAN);

        getLoop(nameSelector);
    }

    @Override
    public void clicked_w() {

    }

    @Override
    public void selecting_name(String name) {
        characterCreator.withName(name);
        getLoop(provenanceSelector);
    }

    @Override
    public void selecting_huntersCamp() {
        characterCreator.withLocation(new ForestCamp(observer));
        getLoop(classSelector);
    }

    @Override
    public void selecting_farm() {

    }

    @Override
    public void selecting_monastery() {

    }

    @Override
    public void selecting_poverty() {

    }

    @Override
    public void selecting_sword() {
        characterCreator.withWeapon(Weapon.SWORD);
        getLoop(introductionOutro);
    }

    @Override
    public void selecting_knife() {

    }

    @Override
    public void selecting_staff() {

    }

    @Override
    public String getPlace() {
        return characterCreator.build().getLocation().getName();
    }

    @Override
    public void selecting_young() {
        //characterCreator.withClass(young);
        getLoop(weaponSelector);
    }

    @Override
    public void selecting_muscle() {

    }

    @Override
    public void selecting_old() {

    }

    @Override
    public void meet_nate_genray() {

        getLoop(nateGenrayMeet);
    }

    @Override
    public void first_dialog_end() {
        characterCreator.build();
        getLoop(endOfIntroduction);
    }

    @Override
    public void marketplace_entry() {
        getLoop(tutorialMarketPlace);
    }

    @Override
    public void southGate_entry() {
        getLoop(tutorialSouthGate);
    }

    @Override
    public void meet_southgate_guard() {

    }


    @Override
    public void outerFields_entry() {
        getLoop(tutorialOuterFields);
    }

    @Override
    public void grandForestEdge_entry() {
        getLoop(tutorialGrandForestEdge);
    }

    @Override
    public void forestCamp_entry() {
        getLoop(tutorialForestCamp);
    }

    @Override
    public void grandForestDepth_entry() {
        getLoop(tutorialGreatForestDepth);
    }

    @Override
    public void grandForestWilderness_entry() {
        getLoop(tutorialGrandForestWilderness);
    }

    @Override
    public void grandForestDeathEnd_entry() {
        getLoop(tutorialGrandForestDeathEnd);
    }

    @Override
    public void narrowStreets_entry() {
        getLoop(tutorialNarrowStreets);
    }
}
