package com.nixsolutions.task3.figur;

public class Square extends Figure {
    private String name = "Квадрат";
    private Coordinate center = new Coordinate(0, 0);
    private double side;

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

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public Coordinate getCoordinate() {
        return center;
    }
}
