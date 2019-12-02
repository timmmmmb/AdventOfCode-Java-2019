package ch.timmmmmb.adventofcode.day02.two;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(Main.class.getResourceAsStream("day02-2.txt"));
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
        int verb = 0;
        int noun = 0;
        int[] inputduplicate;
        outer:while(true) {
            while(verb < 100){
                inputduplicate = intinputs.clone();
                inputduplicate[1] = noun;
                inputduplicate[2] = verb;
                if(calculatePosZero(inputduplicate) == 19690720){
                   break outer;
                }
                verb++;
            }
            noun++;
            verb = 0;
        }
        System.out.println(" noun:"+noun+" verb:"+verb +" result:"+(100*noun+verb));
    }

    private static int calculatePosZero(int[] input){
        int position = 0;
        while(true){
            if(input[position] == 99)
                break;
            else if(input[position] == 1)
                input[input[position+3]] = input[input[position+1]]+input[input[position+2]];
            else if(input[position] == 2)
                input[input[position+3]] = input[input[position+1]]*input[input[position+2]];
            position += 4;
        }
        return input[0];
    }
}
