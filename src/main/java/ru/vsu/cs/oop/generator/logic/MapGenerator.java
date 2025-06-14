package ru.vsu.cs.oop.generator.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ru.vsu.cs.oop.generator.logic.map.CityMap;
import ru.vsu.cs.oop.generator.logic.map.elements.*;


public class MapGenerator {

    private static final Random random = new Random();


    private MapGenerator() {}


    public static final CityMap generate(final int locationsCount, final int maxRoadsPerLocation) {
        if (locationsCount <= 0)
            throw new IllegalArgumentException("Число локаций должно быть положительным");
        else if (maxRoadsPerLocation <= 0)
            throw new IllegalArgumentException("Максимальное число дорог для каждой локации должно быть положительным");
        else if (locationsCount < maxRoadsPerLocation)
            throw new IllegalArgumentException("Максимальное кол-во дорог не может превышать кол-во локаций");

        List<Location> locations = generateLocations(locationsCount);
        List<Road> roads = generateRoads(locations, maxRoadsPerLocation);

        return new CityMap(locations, roads);
    }

    private static List<Location> generateLocations(final int locationsCount) {
        List<Location> locations = new ArrayList<>();

        for (int i = 0; i < locationsCount; i++)
            locations.add(new Location(i, "location_" + i));

        return locations;
    }

    private static List<Road> generateRoads(
                final List<Location> locations,
                final int maxRoadsPerLocation
            ) {
        List<Road> roads = new ArrayList<>();

        if (locations.size() <= 1)
            return roads;

        for (Location start : locations) {
            int roadsCount = MapGenerator.random.nextInt(maxRoadsPerLocation) + 1;

            for (int i = 0; i < roadsCount; i++) {
                Location end = getRandomLocation(locations, random);

                if (start.equals(end) || isConnected(roads, start, end))
                    continue;

                roads.add(new Road(start, end));
            }
        }

        return roads;
    }

    private static Location getRandomLocation(final List<Location> locations, final Random random) {
        int endIndex = random.nextInt(locations.size());
        return locations.get(endIndex);
    }

    private static boolean isConnected(final List<Road> roads, final Location start, final Location end) {
        return roads.stream().anyMatch(road ->
            (road.getStart().equals(start) && road.getEnd().equals(end)) ||
            (road.getStart().equals(end) && road.getEnd().equals(start))
        );
    }
    
}