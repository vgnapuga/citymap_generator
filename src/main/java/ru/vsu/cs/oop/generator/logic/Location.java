package ru.vsu.cs.oop.generator.logic;

public final class Location {
    
    private int id;
    private String name;

    
    public Location(final int id, final String name) {
        this.id = id;
        this.name = name;
    }


    public final int getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

}
