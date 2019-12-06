package ch.timmmmmb.adventofcode.day06.two;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private static HashMap<String, Planet> planets = new HashMap<>();
    public static void main(String[] args){
        Scanner scanner = new Scanner(Main.class.getResourceAsStream("day06-2.txt"));
        Planet you = null;
        Planet san = null;
        //read the input
        while(scanner.hasNextLine()){
            //split line
            String line = scanner.nextLine();
            Planet center = getPlanetByName(line.split("\\)")[0]);
            Planet orbiter = getPlanetByName(line.split("\\)")[1]);
            if(orbiter.name.equals("SAN")){
                san = center;
            }else if(orbiter.name.equals("YOU")){
                you = center;
            }
            orbiter.orbit(center);
        }
        assert you != null;
        int distance = you.calculateDistance(san, null);

        System.out.println(distance);
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
