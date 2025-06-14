package ru.vsu.cs.oop.generator.logic.map.elements;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class RoadTest {

    private Location a = new Location(0, "Ноль");
    private Location b = new Location(1, "Один");

    
    @Test
    void testConstructorAndGetters() {
        Road road = new Road(a, b);

        assertEquals(a, road.getStart());
        assertEquals(b, road.getEnd());
    }

    @Test
    void testEquals() {
        Road road_0 = new Road(a, b);
        Road road_1 = new Road(a, new Location(2, "Два"));

        assertTrue(road_0.equals(road_0));
        assertFalse(road_0.equals(road_1));
    }

}
