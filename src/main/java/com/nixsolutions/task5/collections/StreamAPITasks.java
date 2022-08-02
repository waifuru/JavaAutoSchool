package com.nixsolutions.task5.collections;

import java.util.function.BiFunction;
import java.util.function.Function;

public class StreamAPITasks {

    public static void main(String[] args) {
        Function<Integer, String> intToStringFunction = number1 -> String.valueOf(number1);

        Function<Integer, String> intToStringClass = String::valueOf;

        String methodString = intToStringMethod(5);
        String apply = intToStringFunction.apply(4);
        System.out.println(methodString);
        System.out.println(apply);
    }
    public static String intToStringMethod(Integer number) {
        return String.valueOf(number);
    }
}
