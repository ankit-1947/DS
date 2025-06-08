package com.yahoo.ankit1947.cache.leet;

import com.yahoo.ankit1947.list.single.SListNode;

import java.util.HashMap;

class LRUCache {

    public int capacity;
    public HashMap<Integer,LRUNode> cache;
    private LRUNode first;
    private LRUNode last;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
    }

    public int get(int key) {
        if (cache.containsKey(key))
        {
            LRUNode node = cache.get(key);
            removeNode(node);
            node.next = node.prev = null;
            addNode(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        LRUNode ne = new LRUNode(key,value);
        if (cache.containsKey(key))
        {
            LRUNode node = cache.get(key);
            removeNode(node);
            cache.remove(key);
        } else if (cache.size()==capacity) {
            LRUNode l = last;
            removeNode(last);
            cache.remove(l.key);
        }
        addNode(ne);
        cache.put(key,ne);
    }

    public void addNode(LRUNode node)
    {
        if (first==null)
            first=last=node;
        else
        {
            node.next=first;
            first.prev=node;
            first=node;
        }
    }
    public void removeNode(LRUNode node)
    {
        LRUNode prev = node.prev;
        LRUNode next = node.next;

        if(prev!=null)
        {
            prev.next = next;
        }
        else
        {
            first = next;
        }

        if(next!=null)
        {
            next.prev=prev;
        }
        else
        {
            last=prev;
        }
    }

    public void print() {
        LRUNode current = first;
        while(current!=null){
            System.out.print(current.key + " → ");
            current = current.next;
        }
        System.out.println();

    }
}

class LRUNode
{
    int key;
    int value;
    LRUNode next,prev;

    public LRUNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class Test
{
    public static void main(String[] args) {

        LRUCache l = new LRUCache(10);
        int[][] ops = {
                {10,13},{3,17},{6,11},{10,5},{9,10},{13},
                {2,19},{2},{3},{5,25},{8},{9,22},{5,5},{1,30},{11},
                {9,12},{7},{5},{8},{9},{4,30},{9,3},{9},{10},{10},
                {6,14},{3,1},{3},{10,11},{8},{2,14},{1},{5},{4},
                {11,4},{12,24},{5,18},{13},{7,23},{8},{12},{3,27},
                {2,12},{5},{2,9},{13,4},{8,18},{1,7},{6},{9,29},
                {8,21},{5},{6,30},{1,12},{10},{4,15},{7,22},{11,26},
                {8,17},{9,29},{5},{3,4},{11,30},{12},{4,29},{3},
                {9},{6},{3,4},{1},{10},{3,29},{10,28},{1,20},{11,13},
                {3},{3,12},{3,8},{10,9},{3,26},{8},{7},{5},{13,17},
                {2,27},{11,15},{12},{9,19},{2,15},{3,16},{1},{12,17},
                {9,1},{6,19},{4},{5},{5},{8,1},{11,7},{5,2},{9,28},
                {1},{2,2},{7,4},{4,22},{7,24},{9,26},{13,28},{11,26}
        };

        for (int[] op : ops) {
            if (op.length == 2) {
                System.out.println(l.cache.size() + " capa : "+l.capacity);
                System.out.println("adding : "+ op[0]+" : "+op[1] + "   Exist : "+l.cache.containsKey( op[0]));
                l.put(op[0], op[1]); // key, value


                System.out.println(l.cache.size());
            } else if (op.length == 1) {
                int result = l.get(op[0]);
                System.out.println("get(" + op[0] + ") -> " + result);
                System.out.println(l.cache.size());
            }
            l.print();
            System.out.println("---");


        }}
}


