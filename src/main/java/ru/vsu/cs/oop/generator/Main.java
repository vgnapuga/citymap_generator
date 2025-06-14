package ru.vsu.cs.oop.generator;

import java.io.IOException;

import ru.vsu.cs.oop.generator.logic.MapGenerator;
import ru.vsu.cs.oop.generator.logic.map.CityMap;

public class Main {

    public static void main(String[] args) throws IOException {
        int locationsCount = 10;
        int maxRoads = 3;
        String filePath = "map";

        CityMap map = MapGenerator.generate(locationsCount, maxRoads);
        map.saveToDotFile(filePath + ".dot");

        Runtime.getRuntime().exec("dot -Tpng " + filePath + ".dot " + "-o " + filePath + ".png");

        CityMap loadedMap = CityMap.fromDotFileToCityMap(filePath + ".dot");

        System.out.println(map.getLocations().equals(loadedMap.getLocations()));
        System.out.println(map.getRoads().equals(loadedMap.getRoads()));
    }
    
}