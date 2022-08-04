package com.nixsolutions.task5.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StreamAPITasks {

    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("");
        fillWith(words, "ezvkb");
        fillWith(words, "cdfvdfvdv");
        fillWith(words, "bertybd");
        fillWith(words, "aoiuko");
        words.add("");
        words.forEach(System.out::println);
        System.out.println("---------------------------------------");
        words.stream()
                .map(element -> element.length())
                .forEach(System.out::println);
        System.out.println("---------------------------------------");
        //Predicate<String> nonEmptyPredicate = element -> !element.isEmpty();
        words.stream()
                .filter(element -> !element.isEmpty())
                .filter(element -> !element.contains("d"))
                .forEach(System.out::println);
        System.out.println("---------------------------------------");
        words.stream()
                .sorted()
                .forEach(System.out::println);
    }

    private static void fillWith(List<String> words, String prefix) {
        Random random = new Random();
        for (int i = 0; i < 15; i++) {
            int number = random.nextInt(200);
            words.add(prefix + number);
        }
    }
}
