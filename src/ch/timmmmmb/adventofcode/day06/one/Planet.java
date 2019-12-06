package ch.timmmmmb.adventofcode.day06.one;

import java.util.ArrayList;

class Planet {
    private ArrayList<Planet> orbits = new ArrayList<>();
    private ArrayList<Planet> orbitedBy = new ArrayList<>();
    private String name;

    Planet(String name) {
        this.name = name;
    }

    void orbit(Planet center){
        center.orbitedBy.add(this);
        this.orbits.add(center);
    }

    int getOrbitAmount(){
        int directOrbit = orbits.size();
        if(directOrbit == 0)
            return directOrbit;
        int indirectOrbit = 0;
        for(Planet center:orbits){
            indirectOrbit += center.getOrbitAmount();
        }
        return directOrbit+indirectOrbit;
    }
}
