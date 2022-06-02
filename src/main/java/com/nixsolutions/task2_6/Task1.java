package com.nixsolutions.task2_6;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите 2 числа: ");
        int nums[] = new int[2];
        for (int i = 0; i < nums.length; i++) {
            String s = in.nextLine();
            if (!s.isEmpty()){
                nums[i] = Integer.parseInt(s);}
            else{
                i--;
            }
        }
        min(nums);
    }

        public static void min(int nums[]){
            if (nums[0] > nums[1]) {
                System.out.printf("Минимальное число: %d", nums[1]);
            } else if (nums[1] > nums[0]) {
                System.out.printf("Минимальное число: %d", nums[0]);
            } else {
                System.out.println("Числа одинаковые:(");
            }
        }
}
