package ru.vsu.cd.oop.generator.logic.map.elements;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import ru.vsu.cs.oop.generator.logic.map.elements.*;


class RoadTest {

    private Location a = new Location(0, "Ноль");
    private Location b = new Location(1, "Один");

    
    @Test
    void testConstructorAndGetters() {
        Road road = new Road(a, b);

        assertEquals(a, road.getStart());
        assertEquals(b, road.getEnd());
    }

}
