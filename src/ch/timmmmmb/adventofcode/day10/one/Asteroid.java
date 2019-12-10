package ch.timmmmmb.adventofcode.day10.one;

public class Asteroid {
    private double x, y;

    public Asteroid(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double calculatePitch(Asteroid asteroid){
        double dX = asteroid.x - this.x;
        double dY = asteroid.y - this.y;
        return Math.atan2(dX, dY) + Math.PI;
    }
}
