package com.nixsolutions.task2_6;

import java.io.IOException;
import java.util.Scanner;

public class Task10 {
    public static void main(String[] args) throws IOException {
        Scanner newScanner = new Scanner(System.in);
        System.out.println("Введи строку: ");
        String str = newScanner.next();
        System.out.println("Введи число: ");
        int num = newScanner.nextInt();
        int i = 0;
        while (i < num) {
            System.out.println(str);
            i++;
        }
    }
}
