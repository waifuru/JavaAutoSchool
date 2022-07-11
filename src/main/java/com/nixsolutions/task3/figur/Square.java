package com.nixsolutions.task3.figur;

import lombok.Getter;
import lombok.Setter;

public class Square extends Figure {
    @Setter
    private String name = "Квадрат";

    @Setter
    private Coordinate center = new Coordinate(0, 0);

    @Getter
    @Setter
    private double side;

    @Override
    public String getName() {
        return name;
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
