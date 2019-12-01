package ch.timmmmmb.adventofcode.day01.two;

import java.util.Scanner;


public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(Main.class.getResourceAsStream("day01-2.txt"));
        int sum = 0;
        while(scanner.hasNextInt()){
            sum += calculateFuel(scanner.nextInt());
        }
        System.out.println("Result: "+sum);
    }

    private static int calculateFuel(int mass){
        if(mass==0)
            return 0;
        int fuel = Math.max(mass/3-2, 0);
        return fuel+calculateFuel(fuel);
    }
}
