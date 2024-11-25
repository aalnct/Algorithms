package OAFacebook;

import java.util.*;

public class CommonAncestorDAG {

    public static void main(String[] args) {
        List<List<Character>> pairs = Arrays.asList(
        Arrays.asList('A','B'),
        Arrays.asList('A','C'),
        Arrays.asList('A','D'),
        Arrays.asList('B','G'),
        Arrays.asList('E','F')
        );

        char node1 = 'B';
        char node2 = 'G';

        System.out.println(hasCommonAncestor(pairs, node1, node2));

    }

    static boolean hasCommonAncestor(List<List<Character>> pairs, char node1, char node2) {
        Map<Character,List<Character>> graph = new HashMap<>();

        for (List<Character> pair : pairs) {
            char src = pair.get(0);
            char dest = pair.get(1);

            graph.computeIfAbsent(src, k->new ArrayList<>()).add(dest);
        }

        Set<Character> visited1 = new HashSet<>();
        dfs(graph,node1,visited1);

        Set<Character> visited2 = new HashSet<>();
        dfs(graph,node2,visited2);

        for (char node : visited2) {
            if (visited1.contains(node)) {
                return true;
            }
        }
        return false;
    }

    static void dfs (Map<Character,List<Character>> graph, char node, Set<Character> visited) {
        visited.add(node);
        List<Character> neighbours = graph.get(node);

        if (neighbours != null) {
            for (char neighbour : neighbours) {
                if (!visited.contains(neighbour)) {
                    dfs(graph,neighbour,visited);
                }
            }
        }
    }
}
