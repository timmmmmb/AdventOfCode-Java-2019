package ch.timmmmmb.adventofcode.day10.two;

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

    public double calculateDistance(Asteroid asteroid){
        double dX = asteroid.x - this.x;
        double dY = asteroid.y - this.y;
        return Math.sqrt(dX*dX+dY*dY);
    }

    @Override
    public String toString(){
        return x+" "+y;
    }
}
