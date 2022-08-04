package com.nixsolutions.task5.reflection;

import java.lang.reflect.Field;
import java.util.Random;

public class Program {
    public static void main(String[] args) throws IllegalAccessException {
        Animal dog = new Dog();
        Animal cat = new Cat();
        fillFields(dog);
        fillFields(cat);
        dog.printAllFields();
        cat.printAllFields();
    }

    public static void fillFields(Object object) throws IllegalAccessException {
        Field[] fields = object.getClass().getDeclaredFields();
        Random random = new Random();
        for (Field field : fields) {
            field.setAccessible(true);
            field.set(object, String.valueOf(random.nextInt(200)));
        }
    }
}
