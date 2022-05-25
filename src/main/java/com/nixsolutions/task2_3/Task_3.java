package com.nixsolutions.task2_3;


import java.util.Scanner;

public class Task_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите число: ");
        String n = in.nextLine();
        task_3(n);
    }

    public static void task_3(String n) {
        String[] arr = n.split("\\.");
        int part1 = Integer.parseInt(arr[0]);
        String part2String = arr[1];
        int part2 = Integer.parseInt(part2String);

        if (part2String.length() > 1) {
            part2 = Integer.parseInt(Character.toString(part2String.charAt(0)));
        }

        if (part2 >= 5) {
            part1 += 1;
            System.out.println(part1);
        } else {
            System.out.println(part1);
        }

    }
}


