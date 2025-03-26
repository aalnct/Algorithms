package restart.graph.medium;

import java.util.ArrayList;
import java.util.List;

public class AllPathFromSourceTargetDFS {

    public static void main(String[] args) {
        int[][] graphs = {
                {1, 2},
                {3},
                {3},
                {}
        };

        List<List<Integer>> result = allPaths(graphs);
        for (List<Integer> integers : result) {
            integers.forEach(System.out::print);
        }
    }

    static List<List<Integer>> allPaths(int[][] graphs) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currPath = new ArrayList<>();
        int current = 0;
        int target = graphs.length - 1;
        currPath.add(current);

        dfs(graphs, current, target, currPath, result);

        return result;
    }

    static void dfs(int[][] graphs, int start, int target,
                    List<Integer> currPath, List<List<Integer>> result) {
        if (start == target) {
            result.add(new ArrayList<>(currPath));
            return;
        }

        for (int nei : graphs[start]) {
            currPath.add(nei);
            dfs(graphs, nei, target, currPath, result);

            currPath.remove(currPath.size() - 1);
        }
    }
}
