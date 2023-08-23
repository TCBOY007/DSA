/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adt;

/**
 *
 * @author chook
 */
public class LinkedStack<T> implements StackInterface<T> {
    private Node topNode;
    private int totalNumberData;

    @Override
    public void push(T newData) {
        Node newNode = new Node(newData, topNode);
        topNode = newNode;
        totalNumberData++;
    }

    @Override
    public T pop() {
        T result = null;
        if (!isEmpty()) {
            result = topNode.data;
            topNode = topNode.next;
            totalNumberData--;
        }
        return result;
    }

    @Override
    public T peek() {
        T result = null;
        if (!isEmpty()) {
            result = topNode.data;
        }
        return result;
    }

    @Override
    public int getTotalNumberData() {
        return totalNumberData;
    }
    
    @Override
    public boolean isEmpty() {
        return topNode == null;
    }

    @Override
    public void reset() {
        topNode = null;
        totalNumberData = 0;
    }
    
    
    
    private class Node {

        private T data;
        private Node next;

        private Node(T data) {
            this.data = data;
            this.next = null;
        }

        private Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
    
}
