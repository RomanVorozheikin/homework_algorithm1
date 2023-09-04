package org.example;

import org.example.exceptions.InvalidIndexException;
import org.example.exceptions.NullIndexException;
import org.example.exceptions.NullItemException;
import org.example.exceptions.StringsIsFullException;

import java.util.Arrays;

import static java.util.Arrays.copyOf;

public class StringListImpl implements StringList{
    private Integer[] strings;
    int size=0;

    public StringListImpl() {
        strings = new Integer[10];
    }

    public StringListImpl(int initSize) {
        strings=new Integer[initSize];
    }

    @Override
    public Integer add(Integer item) {
        growSize();
        validateItem(item);
        strings[size++] = item;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        growSize();
        validateItem(item);
        validateIndex(index);
        if (index == size) {
            strings[size++] = item;
            return item;
        }
        System.arraycopy(strings, index, strings, index + 1, size - index);
        strings[index] = item;
        size++;

        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        validateIndex(index);
        validateItem(item);
        strings[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        validateItem(item);

        int index = lastIndexOf(item);

        if (index == -1) {
            throw new NullIndexException();
        }
        if (index == size) {
            System.arraycopy(strings, index + 1, strings, index, size - index);
        }
        size--;
        return remove(index);
    }

    @Override
    public Integer remove(int index) {
        validateIndex(index);
        Integer item = strings[index];
        if (index != size) {
            System.arraycopy(strings, index + 1, strings, index, size - index);
        }
        size--;
        return item;
    }
    @Override
    public boolean contains(Integer item) {
        return indexOf(item)!=-1;
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < size; i++) {
            if (item.equals(strings[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = size-1; i >=0; i--) {
            if (item.equals(strings[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        validateIndex(index);
        return strings[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        return Arrays.equals(otherList.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public Integer[] toArray() {
        return copyOf(strings,size);
    }

    private void validateItem(Integer item) {
        if (item == null) {
            throw new NullItemException();
        }
    }

    private void growSize() {
        if (size == strings.length) {
            grow();
        }
    }

    private void validateIndex(int index) {
        if (index >= size) {
            throw new InvalidIndexException();
        }
    }
    private void grow() {
        Arrays.copyOf(strings, size+size/2);
    }

    private void quickSort(Integer[] arr,int begin,int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private int partition(Integer[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                swapElements(arr, i, j);
            }
        }

        swapElements(arr, i + 1, end);
        return i + 1;
    }

    private void swapElements(Integer[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
