package com.nixsolutions.task2_4;

import java.util.Arrays;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите строку слов: ");
        String n = in.nextLine();
        task3(n);
    }

    public static void task3(String n) {
        String[] words = n.split(" ");
        String bigWord = words[0];

        for (int i = 0; i < words.length; i++) {
            if (bigWord.length() < words[i].length()) {
                bigWord = words[i];
            }
        }
        int bigWordsCounter = 0;

        for (int i = 0; i < words.length; i++) {
            if (bigWord.length() == words[i].length()) {
                bigWordsCounter++;
            }
        }

        if (bigWordsCounter == 1) {
            System.out.println(bigWord);
        }

    }
}
