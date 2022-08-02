package com.nixsolutions.task2_6;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) throws IOException {
        Scanner newScanner = new Scanner(System.in);
        System.out.println("Введи число: ");
        int num = newScanner.nextInt();
        Random random = new Random();
        int secret = random.nextInt(20 + 1);

        if (num > secret || num < secret) {
            for (int i = 0; i <= 6; i++) {
                if (num > secret) {
                    System.out.println("Много");
                    System.out.println("Введи другое число: ");
                    num = newScanner.nextInt();
                } else if (num < secret) {
                    System.out.println("Мало");
                    System.out.println("Введи другое число: ");
                    num = newScanner.nextInt();
                }
            }
        }
        if (num == secret) {
            System.out.println("Ты угадал!");
        }
        if (num > secret || num < secret) {
            System.out.println("Попытки закончились. Не угадал(");
        }
    }

    }

