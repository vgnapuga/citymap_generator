package ru.vsu.cs.oop.generator.logic;

import java.util.List;
import java.util.ArrayList;

public final class CityMap {

    private final List<Location> locations;
    private final List<Road> roads;

    
    public CityMap() {
        this.locations = new ArrayList<>();
        this.roads = new ArrayList<>();
    }

    public CityMap(List<Location> locations, List<Road> roads) {
        this.locations = locations;
        this.roads = roads;
    }


    public final List<Location> getLocations() {
        return new ArrayList<>(this.locations);
    }

    public final List<Road> getRoads() {
        return new ArrayList<>(this.roads);
    }

}