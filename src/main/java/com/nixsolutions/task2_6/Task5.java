package com.nixsolutions.task2_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task5 {
    public static void main(String[] args) throws IOException {
        System.out.println("Введите имя: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] name = new String[1];
        for (int i = 0; i < name.length; i++) {
            name[i] = reader.readLine();
            String zero = name[i];
            if (zero.length() == 0) {
                i--;
            }
        }

        System.out.println("Введите возраст: ");
        int[] age = new int[1];
        for (int i = 0; i < age.length; i++) {
            String s = reader.readLine();
            if (!s.isEmpty()) {
                age[i] = Integer.parseInt(s);
            } else {
                i--;
            }

        }
        identifyAge(age);
    }

    public static void identifyAge(int[] age) {
        if (age[0] < 18) {
            System.out.println("Подрасти еще");
        }
    }
}
