package org.padulano.fabrizio.algorithms.datastructures.linkedlist;

import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    int key;
    Node prev;
    Node next;

    public Node() {}

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

// https://leetcode.com/problems/lru-cache/
public class LRUCache {
    int capacity;

    private Node head;
    private Node tail;

    private Map<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node();
        tail = new Node();

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(!map.containsKey(key)) return -1;

        Node node = map.get(key);
        evict(node);
        addFirst(node);

        return node.val;
    }

    public void put(int key, int value) {
        Node node;


        if(map.containsKey(key)) {
            node = map.get(key);
            node.val = value;
            evict(node);
        } else {
            node = new Node(key, value);
            map.put(key, node);
        }

        addFirst(node);

        if(map.size() > this.capacity) removeLast();

    }

    private void evict(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;

        node.next = null;
        node.prev = null;
    }

    private void addFirst(Node node) {
        var temp = head.next;
        head.next = node;
        node.prev = head;
        node.next = temp;
        temp.prev = node;
    }

    private void removeLast() {
        if(tail.prev != head) {
            map.remove(tail.prev.key);
            evict(tail.prev);
        }
    }
}