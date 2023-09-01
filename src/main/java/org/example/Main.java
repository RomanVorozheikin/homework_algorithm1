package org.example;

public class Main {
    public static void main(String[] args) {
        IntegerListImpl integerList = new IntegerListImpl();

        Integer[] integers1 = integerList.generateRandomArray();
        Integer[] integers2 = integerList.generateRandomArray();
        Integer[] integers3 = integerList.generateRandomArray();

        long start1 = System.currentTimeMillis();
        integerList.sortBubble(integers1);
        System.out.println(System.currentTimeMillis() - start1);

        long start2 = System.currentTimeMillis();
        integerList.sortSelection(integers2);
        System.out.println(System.currentTimeMillis() - start2);

        long start3 = System.currentTimeMillis();
        integerList.sortInsertion(integers3);
        System.out.println(System.currentTimeMillis() - start3);

    }
}