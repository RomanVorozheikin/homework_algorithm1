package org.example;

import java.util.Random;

public class IntegerListImpl implements SortIntegerList {
    @Override
    public Integer[] generateRandomArray() {
        Random random = new Random();
        Integer[] arr = new Integer[100_000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100_000) + 100_000;
        }
        return arr;
    }
    private void swapElements(Integer[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

    @Override
    public void sortBubble(Integer[] arr) {
        boolean isSort = false;
        while (!isSort) {
            isSort = true;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] < arr[i - 1]) {
                    int tmp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = tmp;
                    isSort = false;
                }
            }
        }
    }

    private int min(Integer[] arr,int start) {
        int minValue = arr[start];
        int minIndex = start;
        for (int i = start + 1; i < arr.length; i++) {
            if (arr[i] < minValue) {
                minValue = arr[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    @Override
    public void sortSelection(Integer[] arr) {
        for (int sours = 0; sours < arr.length; sours++) {
            int index = min(arr, sours);

            int tmp = arr[sours];
            arr[sours] = arr[index];
            arr[index] = tmp;
        }
    }
    @Override
    public void sortInsertion(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }
}