package ru.vsu.cs.oop.generator.logic;

public class Road {
    
    private Location start, end;

    
    public Road(final Location start, final Location end) {
        this.start = start;
        this.end = end;
    }


    public final Location getStart() {
        return this.start;
    }

    public final Location getEnd() {
        return this.end;
    }

}
