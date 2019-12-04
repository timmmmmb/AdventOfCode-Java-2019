package ch.timmmmmb.adventofcode.day04.two;

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
        //check that it increments
        for(int i = 0; i<values.length; i++){
            if(previous > values[i] && previous < 10)
                return false;
            previous = values[i];
            if(equalsPrevious(values, i))
                hasDouble = true;
        }
        return hasDouble;
    }

    private static boolean equalsPrevious(int[] values, int index){
        return index-1 >= 0 && values[index] == values[index-1] && (index-2 < 0 || values[index-1] != values[index-2]) && (index+1 >= values.length || values[index] != values[index+1]);
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
