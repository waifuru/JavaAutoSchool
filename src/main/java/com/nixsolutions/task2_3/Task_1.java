package com.nixsolutions.task2_3;

import java.util.Scanner;

//Task 1
public class Task_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите первое число: ");
        String q = in.nextLine();
        System.out.println("Введите второе число: ");
        String w = in.nextLine();
        int q1 = Integer.parseInt(q);
        int w1 = Integer.parseInt(w);
        task_1(q1, w1);
    }

    public static void task_1(int q1, int w1){
        int div = q1 / w1;
        int residue = q1 % w1;
        System.out.printf("Результат: %d\n", div);
        System.out.printf("Остаток: %d\n", residue);

        System.out.println("Результат: " + div);
        System.out.println("Остаток: " + residue);
    }
}
