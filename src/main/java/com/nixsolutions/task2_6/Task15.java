package com.nixsolutions.task2_6;

public class Task15 {
    public static void main(String[] args){
        StringBuilder result = new StringBuilder();
        for (int j = 0; j < 10; j++) {
            result.append("\n");
            for (int i = 1; i <= j + 1; i++) {
                result.append("8");
            }
        }
        System.out.println(result);
    }
}
