package com.nixsolutions.task2_4;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите строку: ");
        String n = in.nextLine();
        task1(n);
    }

    public static void task1(String n) {
        char first = n.charAt(0);
        char last = n.charAt(n.length() - 1);
        String string = String.format("Первый символ: %s\nПоследний символ: %s", first, last);
        System.out.println(string);
        if (n.length() % 2 == 1) {
            char middle = n.charAt(n.length() / 2);
            System.out.println("Средний символ: " + middle);
        }

        int dot = n.indexOf(".");
        if (dot > -1) {
            String string_dot = n.substring(0, dot + 1);
            String result = "Строка до точки: ";
            String result2 = result.concat(string_dot);
            System.out.println(result2);
        }

        int length = n.length();
        String lengthWithoutSpace = n.replaceAll(" ", "");
        int length2 = lengthWithoutSpace.length();
        int result = length - length2;
        System.out.println("Количество пробелов: " + result);
    }
}
