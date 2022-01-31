// I worked on the homework assignment alone, using only course materials.

import java.util.NoSuchElementException;
import java.util.ArrayList;

/**
 * This class represents a LinkedList
 * @author Linda Duong
 * @param <T> represents type of the LinkedList
 * @version 1.0
 */
public class LinkedList<T> {
    private Node<T> head;
    private int size;

    /**
     * Creates an empty LinkedList
     */
    public LinkedList() {
        head = null;
        size = 0;
    }

    /**
     * This method adds another Node at the specified index in the LinkedList
     * @param data data of the Node we want to add
     * @param index index to insert data at
     */
    public void addAtIndex(T data, int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Index is out of bounds!");
        } else {
            Node<T> current = head;
            if (index == 0) {
                head = new Node<>(data, current);
            } else {
                current = head;
                for (int i = 0; i < index - 1 && current != null; i++) {
                    current = current.getNext();
                }
                Node<T> next = new Node<>(data, current.getNext());
                current.setNext(next);
            }
        }
        size++;
    }
    /**
     * This method removes the Node at the specified index
     * @param index index at which we want to removed the Node
     * @return the data that was removed
     */
    public T removeFromIndex(int index) {
        T removedData;
        if (isEmpty()) { // if size is 0 then it would be empty
            return null;
        }
        Node<T> current = head;
        //Node<T> previous = null;
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index is out of bounds!");
        } else {
            if (index == 0) {
                removedData = head.getData();
                head = head.getNext();
            } else {
                // setting previous to the index before the removed data
                int num = 0;
                while (current != null && num < index - 1) {
                    current = current.getNext();
                    num++;
                }
                removedData = current.getNext().getData();
                current.setNext(current.getNext().getNext());
                // previous = current;
                // //System.out.println(previous.getData());
                // for (int i = 0; i < index && current != null; i++) {
                //     current = current.getNext();
                // }
                // // if the index we are removing is the end of the LinkedList
                // if (current.getNext() == null) {
                //     removedData = current.getData();
                // } else { // otherwise if the index is between the 0th index and the last index
                //     removedData = current.getData();
                //     previous.setNext(current.getNext().getNext());
                // }
            }
        }
        size--;
        return removedData;
    }
    /**
     * This method clears out the entire LinkedList
     */
    public void clear() {
        size = 0;
        head = null;
    }
    /**
     * This method finds the data at specified index
     * @param index index at which the data we are looking for is
     * @return the data that is at the specified index
     */
    public T get(int index) {
        if (isEmpty()) {
            return null;
        }
        if (index < 0 || index >= size) { //size - 1
            throw new IllegalArgumentException("Index out of bounds!");
        } else {
            Node<T> current = head;
            for (int i = 0; i < index && current != null; i++) {
                current = current.getNext();
            }
            return current.getData();
        }
    }
    /**
     * This method will return true or false based on if the LinkedList is currently empty.
     * @return a boolean indicating that the LinkedList is empty
     */
    public boolean isEmpty() {
        return (head == null);
    }

    /**
     * This method converts a LinkedList to an ArrayList
     * @return an ArrayList with data from LinkedList
     */
    public ArrayList<T> toArrayList() {
        ArrayList<T> toArray = new ArrayList<>();

        if (isEmpty()) {
            return null;
        }
        Node<T> current = head;
        toArray.add(current.getData());
        while (current.getNext() != null) {
            current = current.getNext();
            toArray.add(current.getData());
        }
        return toArray;
    }
    /**
     * This method takes in a data that’s in the LinkedList, removes that element, and moves that element to the front
     * @param data data that we want to move to the front
     */
    public void toTheFront(T data) {

        T removedData;

        if (isEmpty()) {
            removedData = null;
        }
        // if data is in the head aka the first in the list
        if (head.getData().equals(data)) {
            removedData = head.getData();
            head.setData(removedData);
        } else {
            // if data is elsewhere
            Node<T> current = head;
            Node<T> previous = head;
            int num = 0;
            while (num < size) {
                if (current.getData().equals(data)) {
                    break;
                }
                previous = current;
                current = current.getNext();
                num++;
            }
            if (!current.getData().equals(data)) {
                throw new NoSuchElementException("Data is not in the LinkedList!");
            }
            // while (current.getData() != data && current.getNext() != null) {
            //     current = current.getNext();
            // }
            // removedData = current.getData();
            // head.setData(removedData);
            // head.setNext(current.getNext());
            previous.setNext(previous.getNext().getNext());
            current.setNext(head);
            head = current;
        }
    }
    /**
     * This method finds the middle element of the linked list
     * @return the data of the middle element
     */
    public T accessMiddle() {
        T middleData;

        if (isEmpty()) {
            return null;
        }
        Node<T> one = head;
        Node<T> two = head.getNext();
        while (two != null && two.getNext() != null) {
            one = one.getNext();
            two = two.getNext().getNext();
        }
        middleData = one.getData();
        return middleData;
    }

    //main method testing
    public static void main(String[] args) {
        LinkedList<String> listy = new LinkedList<>();
        listy.addAtIndex("0", 0);
        listy.addAtIndex("1", 1);
        listy.addAtIndex("2", 2);
        listy.addAtIndex("3", 3);
        listy.addAtIndex("4", 4);
        listy.addAtIndex("5", 5);
        listy.addAtIndex("6", 6);
        listy.addAtIndex("7", 7);
        listy.addAtIndex("8", 8);
        listy.addAtIndex("9", 9);
        listy.addAtIndex("10", 10);
        listy.addAtIndex("11", 11);
        //listy.addAtIndex("1.5", 1);
        //listy.toTheFront("1");
        //System.out.println(listy.get(0));
        //System.out.println(listy.get(1));
        //System.out.println(listy.accessMiddle());
        //listy.toArrayList();


        // gradescope errors testing for removeAtIndex method
        //System.out.println(listy.removeFromIndex(1)); // 0 2 3 4 5 6 7 should return 1
        // for (int i = 0; i < listy.size; i++) {
        //     System.out.println(listy.get(i));
        // }
        //System.out.println(listy.removeFromIndex(2)); // 0 2 4 5 6 7 should return 3
        // for (int i = 0; i < listy.size; i++) {
        //     System.out.println(listy.get(i));
        // }
        //System.out.println(listy.removeFromIndex(4)); // 0 2 4 5 7 should return 7 but is not

        for (int i = 0; i < listy.size; i++) {
            System.out.println(listy.get(i));
        }
    }
}