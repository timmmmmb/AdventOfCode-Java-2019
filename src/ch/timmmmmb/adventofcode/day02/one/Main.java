package ch.timmmmmb.adventofcode.day02.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(Main.class.getResourceAsStream("day02-1.txt"));
        //read the first line
        String line = scanner.nextLine();
        //separate all values by comma
        String[] inputs = line.split(",");
        //convert to int
        int[] intinputs = new int[inputs.length];
        int position = 0;
        for(String input:inputs){
            intinputs[position] = Integer.parseInt(input);
            position++;
        }

        intinputs[1] = 12;
        intinputs[2] = 2;
        position = 0;
        while(true){
            if(intinputs[position] == 99)
                break;
            else if(intinputs[position] == 1)
                intinputs[intinputs[position+3]] = intinputs[intinputs[position+1]]+intinputs[intinputs[position+2]];
            else if(intinputs[position] == 2)
                intinputs[intinputs[position+3]] = intinputs[intinputs[position+1]]*intinputs[intinputs[position+2]];
            position += 4;
        }
        System.out.println("Result: "+ intinputs[0]);
    }
}
