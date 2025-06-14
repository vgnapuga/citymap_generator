package ru.vsu.cs.oop.generator.logic;

import org.junit.jupiter.api.Test;
import ru.vsu.cs.oop.generator.logic.map.*;
import static org.junit.jupiter.api.Assertions.*;


class MapGeneratorTest {
    
    @Test
    void testGenerateValidMap() {
        CityMap map = MapGenerator.generate(5, 2);
        assertNotNull(map);
        assertEquals(5, map.getLocations().size());
        assertFalse(map.getRoads().isEmpty());
    }
    
    @Test
    void testInvalidParameters() {
        assertThrows(IllegalArgumentException.class,
            () -> MapGenerator.generate(0, 2));
        
        assertThrows(IllegalArgumentException.class,
            () -> MapGenerator.generate(5, 0));

        assertThrows(IllegalArgumentException.class,
            () -> MapGenerator.generate(3, 4));
    }

}
