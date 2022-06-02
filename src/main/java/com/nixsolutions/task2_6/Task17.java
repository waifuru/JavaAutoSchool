package com.nixsolutions.task2_6;

import java.util.Scanner;

public class Task17 {
    public static void main(String[] args) {
        Scanner newScanner = new Scanner(System.in);
        System.out.println("Введи имя: ");
        String s = newScanner.next();

        for (int i = 0; i < 10; i++) {
            System.out.println(s + " любит меня.");
        }
    }
}
