package com.nixsolutions.task3.figur;

public class Circle extends Figure {
    private String name = "Круг";
    private Coordinate center = new Coordinate(0, 0);
    private double radius;

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCenter(Coordinate center) {
        this.center = center;
    }

    public Coordinate getCenter() {
        return center;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public Coordinate getCoordinate() {
        return center;
    }

}
