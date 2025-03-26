package restart.linkedlist.medium;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private class Node {
        int key;
        int value;
        Node next;
        Node prev;

        public Node (int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        System.out.println("checking for 1 " + lruCache.get(1)); // returns 1 : cache : (2=2, 1=1)
        lruCache.put(3,3); // now since the capacity is full, evict 2
        System.out.println(" Checking for 2" + lruCache.get(2)); // returns -1
        lruCache.put(4,4);
        System.out.println(" checking for 1" + lruCache.get(1)); // -1
        System.out.println(" cjeclom" + lruCache.get(3));
        System.out.println(lruCache.get(4));
    }

    // capacity
    private int capacity;
    private Map<Integer,Node> cache = new HashMap<>();
    private Node head;
    private Node tail;

    public LRUCache (int capacity) {
        this.capacity = capacity;
        // dummy head and tail nodes
        head = new Node(0,0);
        tail = new Node(0,0);

        head.next = tail;
        tail.prev = head;
    }

    private int get (int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        remove(node); // first remove from the cache
        insertIntoHead(node); // then add it back to head of cache

        return node.value;
    }

    private void put (int key, int value) {
        Node node = cache.get(key);
        if (node != null) {
            node.value = value;
            remove(node);
            insertIntoHead(node);
        } else {
            Node newNode = new Node(key,value);
            cache.put(key,newNode);
            insertIntoHead(newNode);
        }
        if (cache.size() > capacity) {
            Node lru = tail.prev; // removing previous element from tail (i.e. least used so far)
            remove(lru);
            cache.remove(lru.key);
        }
    }

    private static void remove (Node node) {
        // A <--> node <--> B (here node is what we are removing)
        node.prev.next = node.next; // node.prev is A, and we set the next pointer to B
        node.next.prev = node.prev; // node.next is B, and we set the previous pointer to A
    }

    private  void insertIntoHead (Node node) {
        // head (dummy) <--> X <--> Y <--> .... <--> tail
        // we want to insert node b/w head and X
        node.next = head.next; // here node.next will be point to X
        node.prev = head; // node.prev will point to head
        // update the pointers for current first node and dummy
        head.next.prev = node; // updating the reference of X to (so head.next is x and its previous pointer pointing to node)
        head.next = node; // current head node next pointer to node
    }
}
