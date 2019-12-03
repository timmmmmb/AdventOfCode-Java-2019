package ch.timmmmmb.adventofcode.day03.two;

import java.util.Collection;
import java.util.LinkedList;

class MultiLine {
    private Collection<Line> lines = new LinkedList<>();
    private int stepsTotal = 0;
    private Point lastPoint = new Point(0,0, stepsTotal);
    MultiLine() {
    }

    void addLine(float x, float y){
        stepsTotal += Math.abs(lastPoint.getX()-x) + Math.abs(lastPoint.getY()-y);
        Point point = new Point(x,y,stepsTotal);
        lines.add(new Line(lastPoint, point));
        lastPoint = point;
    }

    Collection<Line> getLines() {
        return lines;
    }

    Point getLastPoint(){
        return lastPoint;
    }
}
