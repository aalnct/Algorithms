package restart.graph.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Leet code problem number :: 1557
public class MinimumVertices {

    public static void main(String[] args) {
        List<List<Integer>> edges = new ArrayList<>();
        edges.add(Arrays.asList(0,1));
        edges.add(Arrays.asList(0,2));
        edges.add(Arrays.asList(2,5));
        edges.add(Arrays.asList(3,4));
        edges.add(Arrays.asList(4,2));

        List<Integer> result = findSmallestSetOfVertices(6,edges);

        result.forEach(System.out::print);

    }

    static List<Integer> findSmallestSetOfVertices (int n, List<List<Integer>> edges) {
        boolean [] inDegree = new boolean[n];

        for (List<Integer> edge : edges) {
            int destination = edge.get(1);
            inDegree[destination] = true;
        }

        List<Integer> result = new ArrayList<>();

        for (int i=0;  i < n; i++) {
            if (!inDegree[i]) {
                result.add(i);
            }
        }
        return result;
    }
}
