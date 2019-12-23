package ch.timmmmmb.adventofcode.day07.one;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(Main.class.getResourceAsStream("day07-1.txt"));
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
        int max = 0;
        int[] elements = {0, 1, 2, 3, 4};    // input array
        HashSet<int[]> combinations = new HashSet<>();
        int n = 5;
        int[] indexes = new int[n];
        for (int i = 0; i < n; i++) {
            indexes[i] = 0;
        }

        combinations.add(elements.clone());

        int i = 0;
        while (i < n) {
            if (indexes[i] < i) {
                swap(elements, i % 2 == 0 ?  0: indexes[i], i);
                combinations.add(elements.clone());
                indexes[i]++;
                i = 0;
            }
            else {
                indexes[i] = 0;
                i++;
            }
        }
        for(int[] combination: combinations){
            int value = 0;
            for(int j = 0; j<combination.length; j++){
                value = calculateValue(intinputs.clone(), combination, j, value);
            }
            max = Math.max(value, max);
        }
        System.out.println("Result: "+max);
    }

    private static void swap(int[] input, int a, int b) {
        int tmp = input[a];
        input[a] = input[b];
        input[b] = tmp;
    }

    private static int getLastTwoInts(int values){
        String strValue = String.valueOf(values);
        strValue = strValue.substring(strValue.length()-2>=0?strValue.length()-2:strValue.length()-1);
        return Integer.parseInt(strValue);
    }

    private static int getValue(int paramPosition, int opcode, int[] values, int paramPositionOpCode){
        String parametermode = String.valueOf(opcode);
        if(parametermode.length()-paramPositionOpCode-2 < 0){
            parametermode = "0";
        }else{
            parametermode = parametermode.substring(parametermode.length()-paramPositionOpCode-2,parametermode.length()-paramPositionOpCode-1);
        }
        if(parametermode.equals("0")){
            return values[values[paramPosition]];
        }
        return values[paramPosition];
    }

    private static int calculateValue(int[] intinputs, int[] input, int inputPosition, int input2){
        boolean inputused = false;
        int position = 0;
        int output = 0;
        while(true){
            int opcode = getLastTwoInts(intinputs[position]);
            int fullOpcode = intinputs[position];
            if(opcode == 99)
                break;
            else if(opcode == 1){
                intinputs[intinputs[position+3]] = getValue(position+1, fullOpcode, intinputs, 1)+getValue(position+2, fullOpcode, intinputs, 2);
                position += 4;
            }
            else if(opcode == 2){
                intinputs[intinputs[position+3]] = getValue(position+1, fullOpcode, intinputs, 1)*getValue(position+2, fullOpcode, intinputs, 2);
                position += 4;
            }
            else if(opcode == 3){
                if(!inputused) {
                    intinputs[intinputs[position + 1]] = input[inputPosition];
                    inputused = true;
                } else
                    intinputs[intinputs[position+1]] = input2;
                position += 2;
            }else if(opcode == 4){
                //System.out.println(getValue(position+1, fullOpcode, intinputs, 1));
                output = getValue(position+1, fullOpcode, intinputs, 1);
                position += 2;
                inputused = false;
            }else if(opcode == 5){
                if(getValue(position+1, fullOpcode, intinputs, 1)!=0){
                    position = getValue(position+2, fullOpcode, intinputs, 2);
                }else{
                    position+=3;
                }
            }else if(opcode == 6){
                if(getValue(position+1, fullOpcode, intinputs, 1)==0){
                    position = getValue(position+2, fullOpcode, intinputs, 2);
                }else{
                    position+=3;
                }
            }else if(opcode == 7){
                if(getValue(position+1, fullOpcode, intinputs, 1)<getValue(position+2, fullOpcode, intinputs, 2)){
                    intinputs[intinputs[position+3]] = 1;
                }else{
                    intinputs[intinputs[position+3]] = 0;
                }
                position+=4;
            }else if(opcode == 8){
                if(getValue(position+1, fullOpcode, intinputs, 1)==getValue(position+2, fullOpcode, intinputs, 2)){
                    intinputs[intinputs[position+3]] = 1;
                }else{
                    intinputs[intinputs[position+3]] = 0;
                }
                position+=4;
            }
        }
        return output;
    }
}
