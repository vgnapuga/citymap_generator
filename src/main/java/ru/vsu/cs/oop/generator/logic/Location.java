package ru.vsu.cs.oop.generator.logic;

public final class Location {
    
    private int id;
    private String name;


    public Location(final int id, final String name) {
        this.id = id;
        this.name = name;
    }


    //TODO: equals realization
    @Override
    public final boolean equals(Object obj) {
        return true;
    }


    public final int getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

}
