package com.nixsolutions.task2_1;

import com.nixsolutions.task2_1.welcome.Hello;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите имя: ");
        String name = in.nextLine();
        Hello.setupName(name);
        Hello.welcome();
        System.out.println("Hello, world!");
        Hello.byeBye();
    }
}
