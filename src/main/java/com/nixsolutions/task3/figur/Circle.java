package com.nixsolutions.task3.figur;

import lombok.Getter;
import lombok.Setter;

public class Circle extends Figure {

    @Setter
    private String name = "Круг";

    @Getter
    @Setter
    private Coordinate center = new Coordinate(0, 0);

    @Getter
    @Setter
    private double radius;

    @Override
    public String getName() {
        return name;
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
