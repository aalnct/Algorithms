package restart.gemini.partition.rebalancing;

import java.util.Map;
import java.util.TreeMap;

public class HashRing {

    public static void main(String[] args) {
        addNode("NodeA");
        addNode("NodeB");

        printHashRing();

        System.out.println(" Adding adhoc node to ring");
        addNode("NodeC");
        printHashRing();

        System.out.println(" Key apple maps to " + getNodeForKey("1"));
        System.out.println(" Key grapes mapped to " + getNodeForKey("12121212121212"));
    }

    private final static TreeMap<Integer,String> hashRing = new TreeMap<>();
    private final static int hashSize = 100;

    static void addNode (String nodeName) {
        int hash = nodeName.hashCode() % hashSize;
        hashRing.put(hash,nodeName);
    }

    static void removeNode (String nodeName) {
       int hash = nodeName.hashCode() % hashSize;
       hashRing.remove(hash);
    }

    static String getNodeForKey (String key) {
        int hash = key.hashCode() % hashSize;
        Map.Entry<Integer,String> entry = hashRing.ceilingEntry(hash);
        if (entry == null) {
            entry = hashRing.firstEntry();
        }
        return entry.getValue();
    }

    static void printHashRing () {
        System.out.println("Current Hash Ring");
        for (Map.Entry<Integer,String> entry : hashRing.entrySet()) {
            System.out.println(" Hash " + entry.getKey() + " Node " + entry.getValue());
        }
    }


}
