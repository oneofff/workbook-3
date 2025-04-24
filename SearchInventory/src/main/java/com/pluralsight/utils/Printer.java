package com.pluralsight.utils;

public class Printer<T> {

    public void printObjectWithLineBelow(T object) {
        System.out.println(object);
        System.out.println("-".repeat(150));
    }
}
