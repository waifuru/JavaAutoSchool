package com.nixsolutions.task3.figur;

//1. не можешь создать его объект
//2. могуть быть как обычные методы, так и абстрактные
public abstract class Figure implements Comparable<Figure> {
    public abstract double getArea();

    public abstract Coordinate getCoordinate();

    public abstract String getName();

    @Override
    public int compareTo(Figure o) {
        return Double.compare(getArea(), o.getArea());
    }
}
