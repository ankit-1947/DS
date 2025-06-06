package com.yahoo.ankit1947.list.single;

public class MySingleLinkedList<T> implements SingleLinkedList<T> {
    private SListNode<T> head;
    private SListNode<T> tail;

    public MySingleLinkedList() {

    }

    @Override
    public void add(T value) {
        SListNode<T> node = new SListNode(value);
        if (head==null) head=tail=node;
        else
        {
            tail.next = node;
            tail=node;
        }

    }

    @Override
    public void addFirst(T value) {
        SListNode<T> node = new SListNode(value);
        if (head==null) head=tail=node;
        else {
            node.next = head;
            head = node;
        }
    }

    @Override
    public void addAt(int index, T value) {
        SListNode<T> node = new SListNode(value);
        SListNode<T> current = head;
        SListNode<T> prev = head;

        int currentIndex = -1 ;
        while (current!=null)
        {
            currentIndex++;

            if (currentIndex==index)
            {
                if (prev!=null)
                {
                    node.next = current;
                    prev.next=node;

                }
                else
                {
                    head = node;
                    node.next=current;
                }
            }
            prev = current;
            current = current.next;
        }
    }

    @Override
    public boolean remove(T value) {
        SListNode<T> current =  head ;
        SListNode<T> prev = head;
        while (current !=null) {
            if (value.equals(current.val)) {
                if (prev!=null)
                {
                    prev.next=current.next;
                }
                else
                {
                    head = current.next;
                }
                return true;
            }
            prev = current;
            current = current.next;
        }
        return false;

    }

    @Override
    public T removeAt(int index) {
        SListNode<T> current = head;
        SListNode<T> prev = head;

        int currentIndex = -1 ;
        while (current!=null)
        {
            currentIndex++;

            if (currentIndex==index)
            {
                T value = current.val;
                if (prev!=null)
                {
                    prev.next = current.next;
                }
                else
                {
                    head = current.next;
                }
                return value;
            }
            prev = current;
            current = current.next;
        }
        return null;
    }

    @Override
    public boolean contains(T value) {
        SListNode<T> current = head;
        while (current!=null)
        {
            if (value.equals(current.val)) return true;
            current = current.next;
        }
        return false;
    }

    @Override
    public int size() {
        int size = 0 ;
        SListNode<T> current = head;
        while(current!=null){
            size++;
            current = current.next;
        }
        return size;
    }

    @Override
    public void print() {
        SListNode<T> current = head;
        while(current!=null){
            System.out.print(current.val + " → ");
            current = current.next;
        }

    }

    @Override
    public T get(int index) {
        int currentIndex = -1 ;
        SListNode<T> current = head;
        while(current!=null){
            currentIndex++;
            if (currentIndex == index) return current.val;
            current = current.next;
        }
        return null;
    }

    @Override
    public void clear() {
        head = tail = null;
    }

    @Override
    public void reverse() {
        SListNode<T> reverse = null;
        SListNode<T> currentNode = head;

        while(currentNode != null)
        {
            SListNode<T> temp =  currentNode.next;
            currentNode.next = reverse;
            reverse = currentNode;
            currentNode = temp;
        }
        head=reverse;
    }
}
