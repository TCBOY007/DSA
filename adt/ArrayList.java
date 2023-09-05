/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adt;

import java.util.function.Predicate;

/**
 *
 * @author user
 */
public class ArrayList<T> implements ListInterface<T> {

    private T[] array;
    private int numberOfInput;
    private static final int DEFAULT_SIZE = 5;

    public ArrayList() {
        this(DEFAULT_SIZE);
    }

    public ArrayList(int initialCapacity) {
        numberOfInput = 0;
        array = (T[]) new Object[initialCapacity];
    }

    @Override
    public boolean add(T newInput) {
        if (isArrayFull()) {
            doubleArray();
        }
        array[numberOfInput] = newInput;
        numberOfInput++;
        return true;
    }

    @Override
    public boolean add(int newPosition, T newInput) {
        boolean successful = true;

        if ((newPosition >= 0) && (newPosition <= numberOfInput - 1)) {
            if (isArrayFull()) {
                doubleArray();
            }
            array[newPosition] = newInput;
            numberOfInput++;
        } else {
            successful = false;
        }
        return successful;
    }

    @Override
    public T remove(int givenPosition) {
        T result = null;
        if ((givenPosition >= 0) && (givenPosition <= numberOfInput - 1)) {
            result = array[givenPosition];

            if (givenPosition < numberOfInput) {
                removeGap(givenPosition);
            }
            numberOfInput--;
        }
        return result;
    }

    @Override
    public void clear() {
        numberOfInput = 0;
    }

    @Override
    public boolean replace(int givenPosition, T newEntry) {
        boolean isSuccessful = true;
        if ((givenPosition >= 0) && (givenPosition <= numberOfInput - 1)) {
            array[givenPosition] = newEntry;
        } else {
            isSuccessful = false;
        }
        return isSuccessful;
    }

    @Override
    public T getEntry(int givenPosition) {
        T result = null;
        if ((givenPosition >= 0) && (givenPosition <= numberOfInput - 1)) {
            result = array[givenPosition];
        }
        return result;
    }

    @Override
    public boolean contains(T anEntry) {
        boolean found = false;
        for (int index = 0; !found && (index < numberOfInput); index++) {
            if (anEntry.equals(array[index])) {
                found = true;
            }
        }
        return found;
    }

    @Override
    public int getNumberOfEntries() {
        return numberOfInput;
    }

    @Override
    public boolean isEmpty() {
        return numberOfInput == 0;
    }

    private void doubleArray() {
        T[] oldArray = array;
        array = (T[]) new Object[oldArray.length * 2];
        for (int i = 0; i < oldArray.length; i++) {
            array[i] = oldArray[i];
        }
    }

    private boolean isArrayFull() {
        return numberOfInput == array.length;
    }

    @Override
    public String toString() {
        String outputStr = "";
        for (int index = 0; index < numberOfInput; ++index) {
            outputStr += array[index] + "\n";
        }
        return outputStr;
    }

    private void removeGap(int givenPosition) {
        int removedIndex = givenPosition;
        int lastIndex = numberOfInput - 1;
        for (int index = removedIndex; index < lastIndex; index++) {
            array[index] = array[index + 1];
        }
    }
    
    //Add
    //======================================================
    @Override
    public boolean validation(int getPosition) {
        boolean result = true;
        if (numberOfInput <= getPosition - 1) {
            result = false;
        }

        return result;
    }
    
}
