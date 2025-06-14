package ru.vsu.cs.oop.generator.logic.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.io.IOException;

import ru.vsu.cs.oop.generator.logic.map.elements.*;


class CityMapTest {

    private CityMap map;

    
    @BeforeEach
    void createSimpleMap() {
        Location l0 = new Location(0, "l0");
        Location l1 = new Location(1, "l1");

        Road r = new Road(l0, l1);

        map = new CityMap(List.of(l0, l1), List.of(r));
    }


    @Test
    void testConstructorAndGetters() {
        assertEquals(2, map.getLocations().size());
        assertEquals(1, map.getRoads().size());
    }

    @Test
    void testSaveAndLoadDOTFile() throws IOException {
        String filePath = "test_map.dot";

        map.saveToDotFile(filePath);
        CityMap loadedMap = CityMap.fromDotFileToCityMap(filePath);

        assertEquals(map.getLocations().size(), loadedMap.getLocations().size());
        assertEquals(map.getRoads().size(), loadedMap.getRoads().size());

        java.nio.file.Files.deleteIfExists(java.nio.file.Path.of(filePath));
    }

    @Test
    void testEquals() {
        Location l0 = new Location(0, "sfg");
        Location l1 = new Location(1, "adar");

        Road r = new Road(l0, l1);
        
        CityMap map1 = new CityMap(List.of(l0, l1), List.of(r));

        assertTrue(map.equals(map));
        assertFalse(map.equals(map1));
    }

    @Test
    void testInvalidFile() {
        assertThrows(IllegalArgumentException.class,
            () -> CityMap.fromDotFileToCityMap("invalid.txt"));
    }

}
