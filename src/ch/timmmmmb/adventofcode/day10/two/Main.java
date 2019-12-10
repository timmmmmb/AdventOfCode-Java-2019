package ch.timmmmmb.adventofcode.day10.two;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(Main.class.getResourceAsStream("day10-2.txt"));
        ArrayList<Asteroid> asteroids = new ArrayList<>();
        double y = 0;
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            for(double x = 0; x<line.length(); x++){
                if(line.charAt((int) x) == '#'){
                    asteroids.add(new Asteroid(x,y));
                }
            }
            y++;
        }
        //go through each asteroid and get all of the pitches
        int max = 0;
        Asteroid center = null;
        for(Asteroid asteroid: asteroids){
            HashSet<Double> canSee = new HashSet<>();
            for(Asteroid a: asteroids){
                if(a != asteroid){
                    canSee.add(asteroid.calculatePitch(a));
                }
            }
            if(canSee.size()>max){
                center = asteroid;
                max = canSee.size();
            }
        }
        asteroids.remove(center);
        TreeMap<Double, ArrayList<Asteroid>> asteroidGroups = new TreeMap<>();
        //i need to group the asteroids by their pitch
        for(Asteroid asteroid: asteroids){
            assert center != null;
            double pitch = -center.calculatePitch(asteroid);
            if(asteroidGroups.get(pitch) == null){
                ArrayList<Asteroid> newAsteroidGroup = new ArrayList<>();
                newAsteroidGroup.add(asteroid);
                asteroidGroups.put(pitch, newAsteroidGroup);
            }else{
                asteroidGroups.get(pitch).add(asteroid);
            }
        }
        //i then need to sort these groups by their distance to the center
        for(ArrayList<Asteroid> asteroidGroup: asteroidGroups.values()){
            Asteroid finalCenter = center;
            asteroidGroup.sort((o1, o2) -> (int) (finalCenter.calculateDistance(o1) - finalCenter.calculateDistance(o2)));
        }
        int i = 0;
        boolean running = true;
        while(running){
            for(ArrayList<Asteroid> asteroidGroup: asteroidGroups.values()){
                if(asteroidGroup.isEmpty()) continue;
                System.out.println("Removing Asteroid Number: "+(i+1)+" at position: " + asteroidGroup.get(0));
                asteroidGroup.remove(asteroidGroup.get(0));
                i++;
                if(i == 200){
                    running = false;
                    break;
                }
            }

        }

    }

}
