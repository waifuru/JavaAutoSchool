package com.nixsolutions.task5.reflection;

import java.lang.reflect.Field;

public class Animal {
    public void printAllFields() throws IllegalAccessException {
        Field[] declaredFields = this.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            String name = declaredField.getName();
            Object value = declaredField.get(this);
            System.out.println(name + " - " + value);
        }
    }
}
