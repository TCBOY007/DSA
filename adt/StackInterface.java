/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package adt;

/**
 *
 * @author user
 */
public interface StackInterface<T> {
    
    public void push(T newEntry);
    
    public T pop();
    
    public T peek();
    
    public boolean isEmpty();
    
    public boolean clear();
    
    public boolean isFull();
    
    // for checking how many history is made
    public int size();
    
    
}
