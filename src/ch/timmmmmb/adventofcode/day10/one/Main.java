package ch.timmmmmb.adventofcode.day10.one;

import ch.timmmmmb.adventofcode.day08.two.Layer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(Main.class.getResourceAsStream("day10-1.txt"));
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
        for(Asteroid asteroid: asteroids){
            HashSet<Double> canSee = new HashSet<>();
            for(Asteroid a: asteroids){
                if(a != asteroid){
                    canSee.add(asteroid.calculatePitch(a));
                }
            }
            max = Math.max(max, canSee.size());
        }
        System.out.println("Result: "+max);
    }
}
