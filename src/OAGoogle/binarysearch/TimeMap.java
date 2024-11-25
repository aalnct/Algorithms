package OAGoogle.binarysearch;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeMap {

    public static void main(String[] args) {
        TimeMap kv = new TimeMap();
        kv.set("foo", "bar", 1);
        System.out.println(kv.get("foo",1)); // output bar
        System.out.println(kv.get("foo", 3)); // output bar

        kv.set("foo","bar2",4);
        System.out.println(kv.get("foo",4)); // output bar2
        System.out.println(kv.get("foo",5)); // output bar2

    }

    private Map<String, TreeMap<Integer,String>> storage;

    public TimeMap() {
        storage = new HashMap<>();
    }

    public void set(String key, String value, int timeStamp) {
        storage.putIfAbsent(key,new TreeMap<>());
        storage.get(key).put(timeStamp,value);
    }

    public String get (String key, int timeStamp) {
        if (!storage.containsKey(key)) {
            return "";
        }

        TreeMap<Integer,String> timeMapValue = storage.get(key);
        Integer closestTimeStamp = timeMapValue.floorKey(timeStamp);

        if (closestTimeStamp == null) {
            return "";
        }

        return timeMapValue.get(closestTimeStamp);
    }
}
