package ch.timmmmmb.adventofcode.day01.one;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(Main.class.getResourceAsStream("day01-1.txt"));
        int sum = 0;
        while(scanner.hasNextInt()){
            sum += scanner.nextInt()/3-2;
        }
        System.out.println("Result: "+sum);
    }
}
