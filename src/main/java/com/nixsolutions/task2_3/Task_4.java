package com.nixsolutions.task2_3;

import java.util.Scanner;

public class Task_4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите значение a: ");
        String a = in.nextLine();
        System.out.println("Введите значение b: ");
        String b = in.nextLine();
        System.out.println("Введите значение c: ");
        String c = in.nextLine();
        int aInt = Integer.parseInt(a);
        int bInt = Integer.parseInt(b);
        int cInt = Integer.parseInt(c);
        task_3(aInt, bInt, cInt);
    }

    public static void task_3(int aInt, int bInt, int cInt) {
        int aNew = aInt + bInt;
        int bNew = cInt - aInt;
        int cNew = aInt + bInt + cInt;
        System.out.println("a = " + aNew);
        System.out.println("b = " + bNew);
        System.out.println("c = " + cNew);
    }
}
