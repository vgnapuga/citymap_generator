package ru.vsu.cs.oop.generator.logic;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public final class CityMap {

    private final List<Location> locations;
    private final List<Road> roads;


    public CityMap() {
        this.locations = new ArrayList<>();
        this.roads = new ArrayList<>();
    }

    public CityMap(final List<Location> locations, final List<Road> roads) {
        this.locations = locations;
        this.roads = roads;
    }


    public final void GenerateMap(final int locationsCount, final int maxRoadsPerLocation) {
        if (locationsCount <= 0)
            throw new IllegalArgumentException("Число локаций должно быть положительным");
        else if (maxRoadsPerLocation <= 0)
            throw new IllegalArgumentException("Максимальное число дорог для каждой локации должно быть положительным");
        // else if (locationsCount < maxRoadsPerLocation)
        //     throw new IllegalArgumentException("Максимальное кол-во дорог не может превышать кол-во локаций");

        this.locations.clear();
        this.roads.clear();

        generateLocations(locationsCount);
        connectLocations(maxRoadsPerLocation);
    }

    private void generateLocations(final int locationsCount) {
        for (int i = 0; i < locationsCount; i++)
            this.locations.add(new Location(i, "location_" + i));
    }

    private void connectLocations(final int maxRoadsPerLocation) {
        if (this.locations.size() <= 1)
            return;

        Random random = new Random();

        for (Location start : locations) {
            int roadsCount = random.nextInt(maxRoadsPerLocation) + 1;

            for (int i = 0; i < roadsCount; i++) {
                Location end = getRandomLocation(random);

                if (start.equals(end) || isConnected(start, end))
                    continue;

                this.roads.add(new Road(start, end));
            }
        }
    }

    private Location getRandomLocation(final Random random) {
        int endIndex = random.nextInt(locations.size());
        return this.locations.get(endIndex);
    }

    private boolean isConnected(final Location start, final Location end) {
        return this.roads.stream().anyMatch(road ->
            (road.getStart().equals(start) && road.getEnd().equals(end)) ||
            (road.getStart().equals(end) && road.getEnd().equals(start))
        );
    }


    public final List<Location> getLocations() {
        return new ArrayList<>(this.locations);
    }

    public final List<Road> getRoads() {
        return new ArrayList<>(this.roads);
    }

}