package com.nixsolutions.task2_2.welcome;

public class Hello {

    private static String name;

    public static void setupName(String name) {
        Hello.name = name;
    }

    public static void welcome() {
        String string = String.format("Hello, %s!", name);
        System.out.println(string);
    }

    public static void byeBye(){
        String string = String.format("Bye, %s", name);
        System.out.println(string);
    }

}
