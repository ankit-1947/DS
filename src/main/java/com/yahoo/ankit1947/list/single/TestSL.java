package com.yahoo.ankit1947.list.single;

public class TestSL {
    public static void main(String[] args) {
        SingleLinkedList<Integer> list = new MySingleLinkedList<>();

        list.add(10);
        list.add(20);
        list.add(30);
        list.addFirst(5);
        list.addAt(2, 15);

        list.print();  // Expected: 5 → 10 → 15 → 20 → 30 → null

        System.out.println("Contains 20? " + list.contains(20)); // true
        System.out.println("Get at index 3: " + list.get(3));    // 20

        System.out.println("Removed at index 2: " + list.removeAt(2)); // 15
        list.print();  // 5 → 10 → 20 → 30 → null

        list.reverse();
        System.out.println("====");
        list.print();  // 30 → 20 → 10 → 5 → null

        list.clear();
        list.print();  // null
    }
}
