package com.nixsolutions.task2_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;


public class Task4 {
    public static void main(String[] args) throws IOException {
        System.out.println("Введите 2 имени: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] names = new String[2];
        for (int i = 0; i < names.length; i++) {
            names[i] = reader.readLine();
            String zero = names[i];
            if (zero.length() == 0) {
                i--;
            }
        }
        compareNames(names);
    }


    public static void compareNames(String[] names) {
        if (Objects.equals(names[0], names[1])) {
            System.out.println("Имена идентичны");
        } else if ((!Objects.equals(names[0], names[1]) && names[0].length() == names[1].length())) {
            System.out.println("Длины имен равны");
        }
    }


}
