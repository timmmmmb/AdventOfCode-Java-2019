package ch.timmmmmb.adventofcode.day06.one;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private static HashMap<String, Planet> planets = new HashMap<>();
    public static void main(String[] args){
        Scanner scanner = new Scanner(Main.class.getResourceAsStream("day06-1.txt"));
        //read the input
        while(scanner.hasNextLine()){
            //split line
            String line = scanner.nextLine();
            Planet center = getPlanetByName(line.split("\\)")[0]);
            Planet orbiter = getPlanetByName(line.split("\\)")[1]);
            orbiter.orbit(center);
        }
        int orbits = 0;
        for (java.util.Map.Entry<String, Planet> stringPlanetEntry : planets.entrySet()) {
            orbits+=stringPlanetEntry.getValue().getOrbitAmount();
        }
        System.out.println(orbits);
    }

    private static Planet getPlanetByName(String name){
        if(planets.containsKey(name)){
            return planets.get(name);
        }
        Planet planet = new Planet(name);
        planets.put(name, planet);
        return planet;
    }
}
