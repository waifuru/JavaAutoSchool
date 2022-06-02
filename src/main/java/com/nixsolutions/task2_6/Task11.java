package com.nixsolutions.task2_6;

public class Task11 {
    public static void main(String[] args){
        int i = 10;
        int j = 10;
        StringBuilder result = new StringBuilder();

        while (i > 0){
            String s = "s";
            result.append(s);
            i--;
        }
        while (j > 0){
            System.out.println(result);
            j--;
        }
    }
}
