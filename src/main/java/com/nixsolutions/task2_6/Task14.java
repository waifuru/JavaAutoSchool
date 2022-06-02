package com.nixsolutions.task2_6;

import java.util.Scanner;

public class Task14 {
    public static void main(String[] args) {
        Scanner newScanner = new Scanner(System.in);
        System.out.println("Введи число m: ");
        int m = newScanner.nextInt();
        System.out.println("Введи число n: ");
        int n = newScanner.nextInt();
        StringBuilder result = new StringBuilder();
        for (int j = 1; j <= m; j++) {
            int i = 1;
            result.append("\n");
            for (i = 1; i <= n; i++) {
                result.append("8");
            }
        }
        System.out.println(result);
    }
}
