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

        String command = "dot -Tpng " + filePath + ".dot " + "-o " + filePath + ".png";
        Runtime.getRuntime().exec(command);

        CityMap loadedMap = CityMap.fromDotFileToCityMap(filePath + ".dot");

        System.out.println(map.equals(loadedMap));
    }
    
}
