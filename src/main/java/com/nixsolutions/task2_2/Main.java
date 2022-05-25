package com.nixsolutions.task2_2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите имя: ");
        String name = in.nextLine();
        printHelloName(name);
    }

    public static void printHelloName(String name) {
        String string = String.format("Hello, %s!", name);
        System.out.println(string);
    }

}
