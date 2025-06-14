package ru.vsu.cs.oop.generator.logic.map.elements;


public class Location {
    
    private int id;
    private String name;


    public Location(final int id, final String name) {
        this.id = id;
        this.name = name;
    }


    @Override
    public final boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || this.getClass() != obj.getClass())
            return false;

        Location location = (Location) obj;
        return this.id == location.getId() && this.name.equals(location.getName());
    }


    public final int getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

}
