package ru.vsu.cd.oop.generator.logic.map.elements;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import ru.vsu.cs.oop.generator.logic.map.elements.Location;


class LocationTest {

    @Test
    void testConstructorAndGetters() {
        int id = 0;
        String name = "Ноль";

        Location loc = new Location(id, name);

        assertEquals(loc.getId(), id);
        assertEquals(loc.getName(), name);
    }

    @Test
    void testEquals() {
        Location loc_0 = new Location(0, "Ноль");
        Location loc_1 = new Location(1, "Один");

        assertTrue(loc_0.equals(loc_0));
        assertFalse(loc_0.equals(loc_1));
    }
    
}
