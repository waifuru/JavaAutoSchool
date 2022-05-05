package com.nixsolutions.task2_3;

import java.util.Scanner;

public class Task_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите число: ");
        String n = in.nextLine();
        int n1 = Integer.parseInt(n);
        task_2(n1);
    }

    public static void task_2(int n1) {
        int x;
        int sum = 0;
        while (n1 > 0) {
            x = n1 % 10;
            sum += x;
            n1 = n1 / 10;
        }
        System.out.println(sum);
    }

}
