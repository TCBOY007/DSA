/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adt;

import java.util.function.Predicate;


/**
 *
 * @author chook zhen yew
 */
public class LinkedList<T> implements ListInterface<T> {

    private Node firstNode;
    private int totalNumberData;

    public LinkedList() {
        initialize();
    }

    @Override
    public final void initialize() {
        firstNode = null;
        totalNumberData = 0;
    }

    @Override
    public boolean add(T newData) {
        Node newNode = new Node(newData);

        if (!isEmpty()) {
            Node lastNode = getLastNode();
            lastNode.next = newNode;
        } else {                      
            firstNode = newNode;
        }

        totalNumberData++;
        return true;
    }

    @Override   
    public boolean add(int newPosition, T newData) { 
        if (newPosition < 1 || newPosition > totalNumberData + 1) {
            return false; // Invalid position
        }

        Node newNode = new Node(newData);

        if (isEmpty() || newPosition == 1) {
            newNode.next = firstNode;
            firstNode = newNode;
        } else {
            Node previousNode = getNodeAt(newPosition - 1);
            newNode.next = previousNode.next;
            previousNode.next = newNode;
        }

        totalNumberData++;
        return true;
    }

    @Override
    public boolean remove(int position) {
        if (position < 1 || position > totalNumberData) {
            return false; // Invalid position
        }

        if (position == 1) { // Remove the first node
            firstNode = firstNode.next;
        } else {
            Node nodeBefore = getNodeAt(position - 1);
            nodeBefore.next = nodeBefore.next.next;
        }

        totalNumberData--;
        return true;
    }

    @Override
    public boolean replace(int position, T newData) {
        if (position < 1 || position > totalNumberData) {
            return false; // Invalid position
        }

        Node nodeToReplace = getNodeAt(position);
        nodeToReplace.data = newData;

        return true;
    }

    @Override
    public T getData(int position) {
        if (position < 1 || position > totalNumberData) {
            return null; // Invalid position
        }

        Node nodeToGet = getNodeAt(position);
        return nodeToGet.data;
    }

    @Override
    public boolean contains(T data) {

        for (int i = 1; i <= totalNumberData; i++) {
            if (data.equals(getData(i))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int getTotalNumberData() {
        return totalNumberData;
    }

    @Override
    public boolean isEmpty() {
        return (totalNumberData == 0);
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public String toString() {
        String output = "";
        Node currentNode = firstNode;

        for (int i = 1; i <= totalNumberData; i++) {
            output += currentNode.data + "\n";
            currentNode = currentNode.next;
        }
        return output;
    }

    @Override
    public T searchByCriteria(Predicate<T> criteria) {
        Node currentNode = firstNode;
        while (currentNode != null) {
            if (criteria.test(currentNode.data)) {
                return currentNode.data;
            }
            currentNode = currentNode.next;
        }
        return null; // Return null if no matching data is found    
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
    
    private Node getLastNode() {
        
        Node currentNode = firstNode;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        
        return currentNode;
    }
    
    private Node getNodeAt(int position) {
        Node currentNode = firstNode;
        for (int i = 1; i < position; i++) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }

}
