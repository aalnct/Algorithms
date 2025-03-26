package restart.graph.again.graphtheory.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GardenWithNoAdjacents {

    public static void main(String[] args) {
        int [] [] paths = {

        };
        int n = 10000;

        System.out.println(Arrays.toString(flowersWithNoAdjacent(n,paths)));
    }

    static int [] flowersWithNoAdjacent (int n, int [][] paths) {
        int [] results = new int[n];

        if (n == 0) {
            return new int [0];
        }

        List<List<Integer>> graph = new ArrayList<>();

        for (int i=0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        if (paths != null && paths.length > 0) {
            for (int[] path : paths) {
                int garden1 = path[0];
                int garden2 = path[1];

                graph.get(garden1).add(garden2);
                graph.get(garden2).add(garden1); // non-directional graph
            }
        }
        for (int garden =1; garden <= n; garden++) {
            boolean [] usedColors = new boolean[5];

            for (int adjacent : graph.get(garden)) { // getting the neighbours
                if (results[adjacent-1] > 0) {
                    usedColors[results[adjacent-1]] = true;
                }
            }
            int flowerType = 1;
            while (flowerType <= 4 && usedColors[flowerType]) {
                flowerType++;
            }

            results[garden-1] = flowerType;
        }
        return results;
    }
}
