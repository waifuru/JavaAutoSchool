package com.nixsolutions.task2_6;

public class Task12 {
    public static void main(String[] args) {
        int i = 1;
        StringBuilder result = new StringBuilder();

        while (i <= 10) {
            int j = 1;
            result.append("\n");
            while (j <= 10) {
                result.append(i * j).append(" ");
                j++;
            }
            i++;
        }

        System.out.println(result);
    }
}
