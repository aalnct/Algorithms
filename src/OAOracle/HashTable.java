package OAOracle;

import java.util.LinkedList;


class KeyValuePair<K,V> {
    private K key;
    private V value;

    public KeyValuePair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}

public class HashTable <K,V> {

    private static final int DEFAULT_CAPACITY = 16;
    private LinkedList<KeyValuePair<K,V>> [] table;
    private int size;

    public HashTable() {
        this(DEFAULT_CAPACITY);
    }
    public HashTable(int capacity) {
        table = new LinkedList[capacity];
        size = 0;
    }

    private int hash (K key) {
        int hashCode = key.hashCode();
        return (hashCode & 0x7FFFFFFF) % table.length;
    }

    public void put (K key, V value) {
        int index = hash(key);
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }

        for (KeyValuePair<K,V> pair : table[index]) {
            if (pair.getKey().equals(key)) {
                pair = new KeyValuePair<>(key,value);
                return;
            }
        }

        table[index].add(new KeyValuePair<>(key,value));
        size++;
    }

    public V get(K key) {
        int index = hash(key);
        LinkedList<KeyValuePair<K,V>> list = table[index];

        if (list != null) {
            for (KeyValuePair<K,V> pair : list)  {
                if (pair.getKey().equals(key)) {
                    return pair.getValue();
                }
            }
        }
        return null;
    }

    public void remove (K key) {
        int index = hash(key);
        LinkedList<KeyValuePair<K,V>> list = table[index];

        if (list != null) {
            for (KeyValuePair<K,V> pair : list) {
                if (pair.getKey().equals(key)) {
                    list.remove();
                    size--;
                    return;
                }
            }
        }
    }

    public int size () {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        HashTable<String, Integer> hashtable = new HashTable<>();

        hashtable.put("Alice",25);
        hashtable.put("Bob", 30);
        hashtable.put("Charlie", 35);

        System.out.println("Alices age : " + hashtable.get("Alice"));
        System.out.println("Bob's age : " + hashtable.get("Bob"));
        System.out.println("Charlie's age : " + hashtable.get("Charlie"));


        hashtable.remove("Bob");

        System.out.println("Size of Hashtable ::" + hashtable.size());
        System.out.println("is Empty :" + hashtable.isEmpty());
    }

}
