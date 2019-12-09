package ch.timmmmmb.adventofcode.day08.one;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(Main.class.getResourceAsStream("day08-1.txt"));
        int height = 6;
        int width = 25;
        ArrayList<Layer> layers = new ArrayList<>();
        Layer currentLayer = new Layer(height, width);
        layers.add(currentLayer);
        String input = scanner.next();
        for(int i = 0; i < input.length(); i++){
            int intValue = Character.getNumericValue(input.charAt(i));
            if(currentLayer.full){
                currentLayer = new Layer(height, width);
                layers.add(currentLayer);
            }
            currentLayer.addPixel(intValue);
        }
        int min = 99999999;
        for(Layer layer: layers){
            int amount = layer.getAmount(0);
            if(min > amount){
                min = amount;
                currentLayer = layer;
            }
        }

        System.out.println("Result: "+currentLayer.getAmount(1)*currentLayer.getAmount(2));
    }
}
