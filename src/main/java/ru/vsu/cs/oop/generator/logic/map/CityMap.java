package ru.vsu.cs.oop.generator.logic.map;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;


import ru.vsu.cs.oop.generator.logic.map.elements.*;


public class CityMap {

    private final List<Location> locations;
    private final List<Road> roads;


    public CityMap(final List<Location> locations, final List<Road> roads) {
        this.locations = new ArrayList<>(locations);
        this.roads = new ArrayList<>(roads);
    }


    public final void saveToDotFile(String filePath) throws IOException {
        String DOT = this.toDOT();

        if (!filePath.endsWith(".dot"))
            filePath += ".dot";

        Files.writeString(
            Path.of(filePath),
            DOT,
            StandardOpenOption.CREATE,
            StandardOpenOption.TRUNCATE_EXISTING
        );
    }

    private String toDOT() {
        StringBuilder sb = new StringBuilder();

        sb.append("graph CityMap {\n");

        for (Location location : this.locations) {
            sb.append("  ")
              .append(location.getId())
              .append(" [label=\"")
              .append(location.getName())
              .append("\"];\n");
        }

        for (Road road : roads) {
            sb.append("  ")
              .append(road.getStart().getId())
              .append(" -- ")
              .append(road.getEnd().getId())
              .append(";\n");
        }

        sb.append("}\n");

        return sb.toString();
    }

    public static final CityMap fromDotFileToCityMap(String filePath) throws IOException {
        if (!filePath.endsWith(".dot"))
            throw new IllegalArgumentException("Файл должен иметь расширение .dot");

        String content = Files.readString(Path.of(filePath));
        return DOTContentToCityMap(content);
    }

    private static CityMap DOTContentToCityMap(String content) {
        List<Location> locations = new ArrayList<>();
        List<Road> roads = new ArrayList<>();

        Pattern nodePattern = Pattern.compile("(\\d+)\\s*\\[label=\"([^\"]+)\"\\];?$");
        Pattern edgePattern = Pattern.compile("(\\d+)\\s*--\\s*(\\d+);?$");

        Map<Integer, Location> locationMap = new HashMap<>();

        String[] lines = content.split("\\r?\\n");
        for (String line : lines) {
            line = line.trim();

            if (line.isEmpty() || line.equals("{") || line.equals("}"))
                continue;

            Matcher nodeMatcher = nodePattern.matcher(line);
            if (nodeMatcher.matches()) {
                int id = Integer.parseInt(nodeMatcher.group(1));
                String name = nodeMatcher.group(2);

                Location location = new Location(id, name);
                locations.add(location);
                locationMap.put(id, location);

                continue;
            }

            Matcher edgeMatcher = edgePattern.matcher(line);
            if (edgeMatcher.matches()) {
                int startID = Integer.parseInt(edgeMatcher.group(1));
                int endID = Integer.parseInt(edgeMatcher.group(2));

                Location start = locationMap.get(startID);
                Location end = locationMap.get(endID);

                if (start == null || end == null)
                    throw new IllegalArgumentException("В файле некорректные данные");

                roads.add(new Road(start, end));
            }
        }

        return new CityMap(locations, roads);
    }


    public final List<Location> getLocations() {
        return new ArrayList<>(this.locations);
    }

    public final List<Road> getRoads() {
        return new ArrayList<>(this.roads);
    }

}