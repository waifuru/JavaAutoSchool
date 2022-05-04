package com.nixsolutions.task2_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите имя: ");
        String name = in.nextLine();
        printHelloName(name);
    }

    public static void printHelloName(String name) {
        System.out.println("Hello, " + name + "!");
    }

}
