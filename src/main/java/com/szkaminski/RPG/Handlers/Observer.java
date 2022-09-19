package com.szkaminski.RPG.Handlers;

import com.szkaminski.RPG.places.Place;

public interface Observer {

    void clicked_m();
    void clicked_w();

    void selecting_name(String name);

    void selecting_huntersCamp();
    void selecting_farm();
    void selecting_monastery();
    void selecting_poverty();

    void selecting_sword();
    void selecting_knife();
    void selecting_staff();

    void first_dialog_end();
    void marketplace_entry();


    String getPlace();

    void selecting_young();
    void selecting_muscle();
    void selecting_old();

    void meet_nate_genray();

    void southGate_entry();

    void meet_southgate_guard();

    void outerFields_entry();

    void grandForestEdge_entry();

    void forestCamp_entry();

    void grandForestDepth_entry();

    void grandForestWilderness_entry();

    void grandForestDeathEnd_entry();

    void narrowStreets_entry();

}
