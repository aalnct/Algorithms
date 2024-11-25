package leetcode.graph.dfs;

import java.util.ArrayList;
import java.util.List;

public class AllPathFromSourceTarget {

    public static void main(String[] args) {
        int[][] graph = {
                {1,2},
                {3},
                {3},
                {}
        };
        System.out.println(allPathFromSourceTarget(graph));
    }

    private static List<List<Integer>> allPathFromSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();
        if (graph == null || graph.length == 0) {
            return paths;
        }

        dfs(graph,0,new ArrayList<>(),paths);
        return paths;
    }

    private static void dfs(int[][] graph, int node, List<Integer> path, List<List<Integer>> paths) {
        path.add(node);

        if (node == graph.length-1) {
            paths.add(new ArrayList<>(path));
        }

        int[] nextNodes = graph[node];
        for (int nextNode : nextNodes) {
            dfs(graph,nextNode,path,paths);
        }
        // this step is to backtrack to previous node so that we can explore other path also
        path.remove(path.size()-1);
    }
}
