package leetcode.top_150;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> {

    int capacity;
    LinkedHashMap<K,V> cache;

    public static void main(String[] args) {
        LRUCache<Integer,String > cache = new LRUCache<>(3);
        cache.put(1,"One");
        cache.put(2, "Two");
        cache.put(3, "Three");

        System.out.println(cache.get(1));
        System.out.println(cache.get(2));

        cache.put(4, "Four"); // this will remove get(3)

        System.out.println(cache.get(3)); // this will return null
    }

    public LRUCache (int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<>(capacity, 0.75f, true);
    }

    public V get(K key) {
        if (cache.containsKey(key)) {
            makeMostRecent(key);
            return cache.get(key);
        }
        return null;
    }

    public void put(K key, V value) {
        if (cache.size() >= capacity) {
            Iterator<Map.Entry<K,V>> iterator = cache.entrySet().iterator();
            iterator.next();
            iterator.remove();
        }
        cache.put(key,value);
    }

    private void makeMostRecent(K key) {
        V value = cache.remove(key);
        cache.put(key,value);
    }
}
