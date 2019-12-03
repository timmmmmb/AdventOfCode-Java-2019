package ch.timmmmmb.adventofcode.day03.two;

class Point {
    private float x;
    private float y;
    private int steps;

    Point(float x, float y, int steps) {
        this.x = x;
        this.y = y;
        this.steps = steps;
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

    int getSteps(){
        return steps;
    }

    @Override
    public String toString() {
        return  "x=" + x + ", y=" + y;
    }
}
