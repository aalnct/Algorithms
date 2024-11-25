package restart.gemini.util;

public class MyHashMap<K,V> {

    private final Node<K,V>[] buckets;
    private final int capacity = 16; // default
    private int size = 0;

    public MyHashMap () {
        buckets = new Node[capacity];
    }

    static class Node <K,V> {
        private final K key;
        private V value;
        private Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
        // hash function to determine bucket index
        private int getBucketIndex (K key) {
        // where data will be stored
            return Math.abs(key.hashCode() % capacity);
    }

    public void put (K key, V value) {
        int index = getBucketIndex(key);
        Node<K,V> head = buckets[index];

        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        Node<K,V> newNode = new Node<>(key,value);
        newNode.next = buckets[index];
        buckets[index] = newNode;
        size++;
    }

    public V get (K key) {
        int index = getBucketIndex(key);
        Node<K,V> head = buckets[index];

        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    public int getSize () {
        return size;
    }
}

