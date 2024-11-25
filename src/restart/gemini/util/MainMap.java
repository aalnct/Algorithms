package restart.gemini.util;

public class MainMap {
    public static void main(String[] args) {
        MyHashMap<String,Integer> map = new MyHashMap<>();
        map.put("Alice", 25);
        map.put("Bob",30);
        map.put("Charlie",20);

        System.out.println(" Getting value from Map :" + map.get("Alice"));
        System.out.println(" Getting value from Map :" + map.get("Bob"));
        System.out.println(" Getting value from Map :" + map.get("Charlie"));

        // updating value
        map.put("Alice",26);
        System.out.println(" Getting updated value for Alice " + map.get("Alice"));

        System.out.println(" Size of Map " + map.getSize());
    }
}
