package com.nixsolutions.task2_1.welcome;

public class Hello {

    private static String name;

    public static void setupName(String name) {
        Hello.name = name;
    }

    public static void welcome() {
        System.out.println("Hello, " + name + "!");
    }

    public static void byeBye(){
        System.out.println("Bye, " + name);
    }

}
