package ch.timmmmmb.adventofcode.day04.one;

public class Main {
    public static void main(String[] args){
        int i = 372037;
        int amount = 0;
        do {
            if(isPassword(convertArray(i)))
                amount++;
            i = incrementInt(i);
        } while (i <= 899999);
        System.out.println("Result: "+amount);
    }

    private static boolean isPassword(int[] values){
        boolean hasDouble = false;
        int previous = 10;
        for(int value: values){
            if(value == previous)
                hasDouble = true;
            if(previous > value && previous < 10)
                return false;
            previous = value;
        }
        return hasDouble;
    }

    private static int incrementInt(int input){
        return input+1;
    }

    private static int[] convertArray(int input){
        String temp = Integer.toString(input);
        int[] newGuess = new int[temp.length()];
        for (int i = 0; i < temp.length(); i++)
        {
            newGuess[i] = temp.charAt(i) - '0';
        }
        return newGuess;
    }
}
