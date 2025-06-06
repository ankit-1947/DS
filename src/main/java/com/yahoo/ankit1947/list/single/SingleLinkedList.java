package com.yahoo.ankit1947.list.single;

public interface SingleLinkedList<T> {

    // Adds an element at the end of the list
    void add(T value);

    // Adds an element at the beginning of the list
    void addFirst(T value);

    // Adds an element at a specific index
    void addAt(int index, T value);

    // Removes the first occurrence of a value
    boolean remove(T value);

    // Removes the element at a specific index
    T removeAt(int index);

    // Checks if the list contains a value
    boolean contains(T value);

    // Returns the size of the list
    int size();

    // Prints the list (for debugging)
    void print();

    // Returns the value at a given index
    T get(int index);

    // Clears the entire list
    void clear();

    // Reverses the linked list
    void reverse();
}