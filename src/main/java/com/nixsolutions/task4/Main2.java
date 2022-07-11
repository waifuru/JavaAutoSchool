package com.nixsolutions.task4;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) throws InterruptedException {
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
        try {
            int zero = 5 / 0;
        } catch (ArithmeticException e) {
            System.out.println("You shall not fall!");
        }
    }

    public static void min(int nums[]) throws InterruptedException {
        Thread.sleep(3000);
        if (nums[0] > nums[1]) {
            System.out.printf("Минимальное число: %d", nums[1]);
        } else if (nums[1] > nums[0]) {
            System.out.printf("Минимальное число: %d", nums[0]);
        } else {
            System.out.println("Числа одинаковые:(");
        }
        System.out.println();
    }
}
