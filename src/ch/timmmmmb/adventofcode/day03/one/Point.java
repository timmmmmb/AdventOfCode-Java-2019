package ch.timmmmmb.adventofcode.day03.one;

class Point {
    private float x;
    private float y;

    Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    float getX() {
        return x;
    }

    float getY() {
        return y;
    }

    float getDistance(Point point){
        return Math.abs(point.getX()-x) + Math.abs(point.getY()-y);
    }

    @Override
    public String toString() {
        return  "x=" + x + ", y=" + y;
    }
}
