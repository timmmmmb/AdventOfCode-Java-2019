package ch.timmmmmb.adventofcode.day03.one;

import java.util.Collection;
import java.util.LinkedList;

public class MultiLine {
    private Collection<Line> lines = new LinkedList<>();
    private Point lastPoint = new Point(0,0);
    MultiLine() {
    }

    public void addLine(Point point){
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
