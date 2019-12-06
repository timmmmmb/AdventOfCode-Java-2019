package ch.timmmmmb.adventofcode.day06.two;

import java.util.ArrayList;

class Planet {
    private ArrayList<Planet> orbits = new ArrayList<>();
    private ArrayList<Planet> orbitedBy = new ArrayList<>();
    String name;

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

    int calculateDistance(Planet planet, Planet previous){
        if(this.orbitedBy.contains(planet) || this.orbits.contains(planet))
            return 1;
        int min = 1000000;
        for(Planet p : orbitedBy){
            if(p != previous){
                min = Math.min(p.calculateDistance(planet, this), min);
            }
        }
        for(Planet p : orbits){
            if(p != previous){
                min = Math.min(p.calculateDistance(planet, this), min);
            }
        }
        return min+1;
    }
}
