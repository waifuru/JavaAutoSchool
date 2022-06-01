package com.nixsolutions.task2_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task1 {
    public static void main(String[] args) throws IOException {
        initializeArray();
    }

    public static void initializeArray() throws IOException {
        System.out.println("Введите массив из 20 чисел: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] list = new int[20];
        for (int i = 0; i < list.length; i++) {
            String s = reader.readLine();
            if (!s.isEmpty()){
                list[i] = Integer.parseInt(s);}
            else{
                i--;
            }
        }
        System.out.println("Находим самое большое число...");
        max(list);
    }

    public static void max(int[] list) {
        int max = list[0];
        for (int i = 0; i < list.length; i++) {
            if (list[i] > max) {
                max = list[i];
            }
        }
        System.out.println(max);

    }

}
