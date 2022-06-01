package com.nixsolutions.task2_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task4 {
    public static void main(String[] args) throws IOException {
        initializeArray();
    }

    public static void initializeArray() throws IOException {
        System.out.println("Введите массив из 10 чисел: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] list = new int[10];
        for (int i = list.length-1; i >= 0; i--) {
            String s = reader.readLine();
            if (!s.isEmpty()) {
                list[i] = Integer.parseInt(s);
            } else {
                i++;
            }
        }

        System.out.println("Переворачиваем массив чисел...");

        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }
    }
}

