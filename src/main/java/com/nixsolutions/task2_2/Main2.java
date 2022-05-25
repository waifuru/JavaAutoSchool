package com.nixsolutions.task2_2;

import com.nixsolutions.task2_2.welcome.Hello;

import static com.nixsolutions.task2_2.welcome.Hello.byeBye;
import static com.nixsolutions.task2_2.welcome.Hello.setupName;
import static com.nixsolutions.task2_2.welcome.Hello.welcome;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите имя: ");
        String name = in.nextLine();
        setupName(name);
        welcome();
        System.out.println("Hello, world!");
        byeBye();
    }
}
