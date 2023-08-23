/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package adt;

/**
 *
 * @author chook
 */
public interface StackInterface<T> {

    public void push(T newData);

    public T pop();

    public T peek();

    public int getTotalNumberData();
    
    public boolean isEmpty();

    public void reset();
}
