package com.nixsolutions.task2_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task2 {
    public static void main(String[] args) throws IOException {
        initializeArray();
    }

    public static void initializeArray() throws IOException {
        System.out.println("Введите строку (10 раз): ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] list = new String[10];
        for (int i = 0; i < list.length - 2; i++) {
            list[i] = reader.readLine();
            String zero = list[i];
            if (zero.length() == 0) {
                i--;
            }
        }
        //System.out.println(Arrays.toString(list));
        System.out.println("Переворачиваем массив строк...");

        for (int i = list.length - 1; i >= 0; i--) {
            System.out.println(list[i]);
        }

    }
}
