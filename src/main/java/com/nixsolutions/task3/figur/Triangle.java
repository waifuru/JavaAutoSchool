package com.nixsolutions.task3.figur;

import lombok.Getter;
import lombok.Setter;

public class Triangle extends Figure {

    @Setter
    private String name = "Треугольник";

    @Setter
    private Coordinate center = new Coordinate(0, 0);

    @Getter
    @Setter
    private double sideA;

    @Getter
    @Setter
    private double sideB;

    @Getter
    @Setter
    private double sideC;

    @Override
    public String getName() {
        return name;
    }

    public double getPerimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    public double getArea() {
        double p = getPerimeter();
        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
    }

    @Override
    public Coordinate getCoordinate() {
        return center;
    }
}
