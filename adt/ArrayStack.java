/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adt;

/**
 *
 * @author user
 */
public class ArrayStack<T> implements StackInterface<T> {

    private T[] array;
    private int topIndex; // index of top entry
    private static final int DEFAULT_CAPACITY = 50;

    public ArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayStack(int initialCapacity) {
        array = (T[]) new Object[initialCapacity];
        topIndex = -1;
    }

    @Override
    public void push(T newEntry) {
        topIndex++;

        if (topIndex < array.length) {
            array[topIndex] = newEntry;
        }

    }

    @Override
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T poppedItem = array[topIndex];
        array[topIndex] = null; // Clear the reference
        topIndex--;
        return poppedItem;

    }

    @Override
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return array[topIndex];

    }

    @Override
    public boolean isEmpty() {
        return topIndex == -1;

    }

    @Override
    public boolean isFull() {
        return topIndex == array.length - 1;
    }

    @Override
    public boolean clear() {
        for (int i = 0; i <= topIndex; i++) {
            array[i] = null;
        }
        topIndex = -1;
        return true;
    }

    @Override
    public int size() {
        return topIndex + 1;
    }

}
