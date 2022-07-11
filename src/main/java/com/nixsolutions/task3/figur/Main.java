package com.nixsolutions.task3.figur;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Figure[] figures = new Figure[10];
        for (int i = 0; i < figures.length; i++) {
            figures[i] = getRandomFigure();
        }
        Arrays.sort(figures);
        for (int i = 0; i < figures.length; i++) {
            Figure figure = figures[i];
            System.out.printf("%s, S=%s%n", figure.getName(), figure.getArea());
        }
    }

    public static Figure getRandomFigure() {
        Random random = new Random();
        int randomFigure = random.nextInt(30);
        if (randomFigure < 10) {
            Circle circle = new Circle();
            circle.setCenter(new Coordinate(random.nextInt(), random.nextInt()));
            circle.setRadius(random.nextDouble());
            return circle;
        } else if (randomFigure < 20){
            Triangle triangle = new Triangle();
            triangle.setCenter(new Coordinate(random.nextInt(), random.nextInt()));
            triangle.setSideA(random.nextDouble());
            triangle.setSideB(random.nextDouble());
            triangle.setSideC(random.nextDouble());
            return triangle;
        } else {
            Square square = new Square();
            square.setCenter(new Coordinate(random.nextInt(), random.nextInt()));
            square.setSide(random.nextDouble());
            return square;
        }
    }
}
