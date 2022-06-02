package com.nixsolutions.task2_6;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите 4 числа: ");
        int[] nums = new int[4];
        for (int i = 0; i < nums.length; i++) {
            String s = in.nextLine();
            if (!s.isEmpty()) {
                nums[i] = Integer.parseInt(s);
            } else {
                i--;
            }
        }
        max(nums);
    }

    public static void max(int[] nums) {
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        System.out.printf("Максимальное число: %d", max);
    }
}
