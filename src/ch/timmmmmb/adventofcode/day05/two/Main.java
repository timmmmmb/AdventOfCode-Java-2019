package ch.timmmmmb.adventofcode.day05.two;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(Main.class.getResourceAsStream("day05-2.txt"));
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
        int input = 5;
        position = 0;
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
                intinputs[intinputs[position+1]] = input;
                position += 2;
            }else if(opcode == 4){
                System.out.println(getValue(position+1, fullOpcode, intinputs, 1));
                position += 2;
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


}
