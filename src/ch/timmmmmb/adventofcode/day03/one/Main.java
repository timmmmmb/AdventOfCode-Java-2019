package ch.timmmmmb.adventofcode.day03.one;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(Main.class.getResourceAsStream("day03-1.txt"));
        //read the first line
        String line = scanner.nextLine();
        //we get to the solution in three steps
        //first we create line and point objects
        MultiLine multiLine1 = createLine(line.split(","));
        line = scanner.nextLine();
        MultiLine multiLine2 = createLine(line.split(","));
        ArrayList<Point> points = new ArrayList<>();
        //we now get each intersection
        for(Line l1: multiLine1.getLines()){
            for(Line l2: multiLine2.getLines()){
                Point p = l1.intersects(l2);
                if(p!=null){
                    points.add(p);
                }
            }
        }
        Point center = new Point(0,0);
        float minDistance = 100000;
        for(Point point:points){
            float distance = center.getDistance(point);
            if(distance < minDistance){
                minDistance = distance;
            }
        }

        System.out.println("Result: " + minDistance);
    }

    private static MultiLine createLine(String[] inputs){
        MultiLine multiLine = new MultiLine();
        for(String input:inputs){
            String opcode = input.substring(0,1);
            int distance = Integer.parseInt(input.substring(1));
            Point lastPoint = multiLine.getLastPoint();
            switch (opcode){
                case "U":
                    multiLine.addLine(new Point(lastPoint.getX(), lastPoint.getY()+distance));
                    break;
                case "D":
                    multiLine.addLine(new Point(lastPoint.getX(), lastPoint.getY()-distance));
                    break;
                case "L":
                    multiLine.addLine(new Point(lastPoint.getX()+distance, lastPoint.getY()));
                    break;
                case "R":
                    multiLine.addLine(new Point(lastPoint.getX()-distance, lastPoint.getY()));
                    break;
            }
        }
        return multiLine;
    }
}
