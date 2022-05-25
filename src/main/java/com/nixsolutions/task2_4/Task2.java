package com.nixsolutions.task2_4;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите исходную строку: ");
        String n1 = in.nextLine();
        System.out.println("Введите подстроку, которую нужно заменить: ");
        String n2 = in.nextLine();
        System.out.println("На что будем менять? 0_0: ");
        String n3 = in.nextLine();
        task1(n1, n2, n3);
    }

    public static void task1(String n1, String n2, String n3) {
        String editSegment = n1.replaceAll(n2, n3);
        System.out.println(editSegment);
    }
}
