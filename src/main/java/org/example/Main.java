package org.example;

import java.lang.reflect.Array;
import java.util.Arrays;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        StringListImpl stringList = new StringListImpl();
        stringList.add("123");
        stringList.add("de");

        System.out.println(stringList.add(1, "456"));
    }
}