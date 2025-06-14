package ru.vsu.cs.oop.generator.logic.map.elements;


public class Road {
    
    private Location start, end;


    public Road(final Location start, final Location end) {
        this.start = start;
        this.end = end;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;
            
        Road road = (Road) obj;
        return start.equals(road.start) && end.equals(road.end);
    }


    public final Location getStart() {
        return new Location(start.getId(), start.getName());
    }

    public final Location getEnd() {
        return new Location(end.getId(), end.getName());
    }

}
