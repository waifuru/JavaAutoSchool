package com.nixsolutions.task2_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Task3 {
    public static void main(String[] args) throws IOException {
        initializeArray();
    }

    public static void initializeArray() throws IOException {
        System.out.println("Введите строку (10 раз): ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] list = new String[10];
        int[] integers = new int[10];
        for (int i = 0; i < list.length; i++) {
            list[i] = reader.readLine();
            String zero = list[i];
            if (zero.length() == 0) {
                i--;
            }
        }

        System.out.println("Вычисляем длину каждой строки...");

        for (int i = 0; i < integers.length; i++){
            String str = list[i];
            int str_length = str.length();
            integers[i] = str_length;
        }

        for (int i = 0; i < integers.length; i++){
            System.out.println(integers[i]);
        }
    }
}
