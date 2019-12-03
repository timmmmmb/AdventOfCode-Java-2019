package ch.timmmmmb.adventofcode.day03.two;

class Line {
    private Point start;
    private Point end;

    Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }


    private Point doIntersect(float p0_x, float p0_y, float p1_x, float p1_y, int step1,
                              float p2_x, float p2_y, float p3_x, float p3_y, int step2)
    {
        float s1_x, s1_y, s2_x, s2_y;
        s1_x = p1_x - p0_x;     s1_y = p1_y - p0_y;
        s2_x = p3_x - p2_x;     s2_y = p3_y - p2_y;

        float s, t;
        float v = -s2_x * s1_y + s1_x * s2_y;
        s = (-s1_y * (p0_x - p2_x) + s1_x * (p0_y - p2_y)) / v;
        t = ( s2_x * (p0_y - p2_y) - s2_y * (p0_x - p2_x)) / v;

        if (s >= 0 && s <= 1 && t >= 0 && t <= 1)
        {
            // Collision detected
            float newX = p0_x + (t * s1_x);
            float newY = p0_y + (t * s1_y);
            return new Point(newX, newY, (int) (step1+step2+Math.abs(p1_x-newX)+Math.abs(p3_x-newX)+Math.abs(p1_y-newY)+Math.abs(p3_y-newY)));
        }

        return null; // No collision
    }

    Point intersects(Line line){
        return doIntersect(line.end.getX(), line.end.getY(), line.start.getX(), line.start.getY(), line.start.getSteps(), this.end.getX(), this.end.getY(), this.start.getX(), this.start.getY(), this.start.getSteps());
    }

    @Override
    public String toString() {
        return "Line{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
