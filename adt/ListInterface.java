/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package adt;

import java.util.function.Predicate;

/**
 *
 * @author chook zhen yew
 */
public interface ListInterface<T> {
    

    public boolean add(T newdata);

    public boolean add(int newPosition, T newdata);

    public boolean remove(int position);

    public void reset();

    public boolean replace(int position, T newdata);

    public T getData(int position);

    public boolean contains(T data);
    
    public T searchByCriteria(Predicate<T> criteria);
    
    public int getTotalNumberData();

    public boolean isEmpty();

    public boolean isFull();
}
