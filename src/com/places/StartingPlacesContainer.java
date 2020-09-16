package com.places;

import com.places.Forest.ForestCamp;
import com.places.Village.MarketPlace;
import com.places.Village.NarrowStreets;
import com.places.Village.Poverty;
import com.places.World.Farm;
import com.places.World.Monastery;
import com.places.World.OuterFields;

import java.util.ArrayList;
import java.util.List;

public class StartingPlacesContainer {


    private List<Place> startingPlacesList;

    public StartingPlacesContainer() {
        this.startingPlacesList = new ArrayList<>();
        startingPlacesList.add(new ForestCamp());
        startingPlacesList.add(new Monastery());
        startingPlacesList.add(new Farm());
        startingPlacesList.add(new Poverty());
    }

    public List<Place> getStartingPlacesList() {

        return startingPlacesList;
    }
}
