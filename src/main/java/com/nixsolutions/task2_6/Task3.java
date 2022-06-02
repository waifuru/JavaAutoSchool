package com.nixsolutions.task2_6;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите 3 числа: ");
        int[] nums = new int[3];
        for (int i = 0; i < nums.length; i++) {
            String s = in.nextLine();
            if (!s.isEmpty()) {
                nums[i] = Integer.parseInt(s);
            } else {
                i--;
            }
        }
        arrangeNums(nums);
    }

    public static void arrangeNums(int[] nums) {
        int max = nums[0];
        int middle = nums[1];
        int min = nums[2];
        int x;

        if (max > middle) {
            x = max;
            max = middle;
            middle = x;
        }
        if (middle > min) {
            x = middle;
            middle = min;
            min = x;
        }
        if (max > middle) {
            x = max;
            max = middle;
            middle = x;
        }

        System.out.println("Сортируем по убыванию...");
        System.out.println(min);
        System.out.println(middle);
        System.out.println(max);
    }
}
