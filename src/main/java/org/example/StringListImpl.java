package org.example;

import org.example.exceptions.InvalidIndexException;
import org.example.exceptions.NullIndexException;
import org.example.exceptions.NullItemException;
import org.example.exceptions.StringsIsFullException;

import java.util.Arrays;

import static java.util.Arrays.copyOf;

public class StringListImpl implements StringList{
    private final String[] strings;
    int size=0;

    public StringListImpl() {
        strings = new String[10];
    }

    public StringListImpl(int initSize) {
        strings=new String[initSize];
    }

    @Override
    public String add(String item) {
        validateSize();
        validateItem(item);
        strings[size++] = item;
        return item;
    }

    @Override
    public String add(int index, String item) {
        validateSize();
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
    public String set(int index, String item) {
        validateIndex(index);
        validateItem(item);
        strings[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
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
    public String remove(int index) {
        validateIndex(index);
        String item = strings[index];
        if (index != size) {
            System.arraycopy(strings, index + 1, strings, index, size - index);
        }
        size--;
        return item;
    }

    @Override
    public boolean contains(String item) {
        return indexOf(item)!=-1;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            if (item.equals(strings[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = size-1; i >=0; i--) {
            if (item.equals(strings[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
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
    public String[] toArray() {
        return copyOf(strings,size);
    }

    private void validateItem(String item) {
        if (item == null) {
            throw new NullItemException();
        }
    }

    private void validateSize() {
        if (size == strings.length) {
            throw new StringsIsFullException();
        }
    }

    private void validateIndex(int index) {
        if (index >= size) {
            throw new InvalidIndexException();
        }
    }
}
