/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package adt;

import java.util.Iterator;
import java.util.function.Predicate;

/**
 *
 * @author chenc
 */
public interface ListInterface<T> {

    public Iterator<T> getIterator();

    public boolean add(T newdata);

    public boolean add(int newPosition, T newdata);

    public boolean remove(int position);

    public void reset();

    public boolean replace(int position, T newdata);

    public T getData(int position);

    public boolean contains(T data);

    public ListInterface<T> search(Predicate<T> criteria);

    public int getTotalNumberData();

    public boolean isEmpty();

    public boolean isFull();

    public int getIndex(T anEntry);

}
