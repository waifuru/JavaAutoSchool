package com.nixsolutions.task2_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task5 {
    public static void main(String[] args) throws IOException {
        initializeArray();
    }

    public static void initializeArray() throws IOException {
        System.out.println("Введите массив из 20 чисел: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] list = new int[20];
        for (int i = 0; i < list.length; i++) {
            String s = reader.readLine();
            if (!s.isEmpty()) {
                list[i] = Integer.parseInt(s);
            } else {
                i--;
            }
        }
        System.out.println("Второй маленький массив содержит числа: ");

        int[] littleList1 = new int[10];
        int[] littleList2 = new int[10];

        for (int i = 0; i < list.length-10; i++) {
            littleList1[i] = list[i];
        }

        for (int i = 10, j = 0; i < list.length; i++, j++) {
            littleList2[j] = list[i];
        }

        for (int i = 0; i < littleList2.length; i++) {
            System.out.println(littleList2[i]);
        }

    }
}
