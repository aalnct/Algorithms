package leetcode.graph.disjointset;

import java.util.*;

public class SmallestStringWithSwap {

    static int [] parent;
    public static void main(String[] args) {
        String s = "dcab";
        List<List<Integer>> pairs = Arrays.asList(
                Arrays.asList(0,3),
                Arrays.asList(1,2)
        );

        System.out.println(smallestStringWithSwap(s,pairs));
    }

    private static String smallestStringWithSwap(String s, List<List<Integer>> pairs) {
        int n = s.length();
        parent = new int[n];

        for (int i=0; i < n; i++) {
            parent[i]=i;
        }

        for (List<Integer> pair : pairs) {
            int x = pair.get(0);
            int y = pair.get(1);

            union(x, y);
        }
            // create a map to group characters with in the same component
        Map<Integer, List<Character>> componentMap = new HashMap<>();
            for (int i=0; i < n; i++) {
                int root = find(i); // find the root of i and use that key in map
                componentMap.computeIfAbsent(root, k-> new ArrayList<>()).add(s.charAt(i));
            }

            // sort the character
        for (List<Character> component : componentMap.values()) {
            Collections.sort(component);
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i < n; i++) {
            int root = find(i);
            sb.append(componentMap.get(root).remove(0));
        }

        return sb.toString();
    }

    private static int find(int x) {
        if (parent[x] == x) {
            return parent[x];
        }
        return parent[x] = find(parent[x]);
    }

    private static void union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);

        if (parentX != parentY) {
            parent[parentX] = parentY;
        }
    }
}
