package com.nixsolutions.task2_6;

public class Task18 {
    public static void main(String[] args) throws InterruptedException {
        for(int i = 3; i >= 0; i--){
            System.out.println(i);
            Thread.sleep(10000);
        }
        System.out.println("Boom!");
    }
}
