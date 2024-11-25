package leetcode.graph.dfs;

import java.util.ArrayList;
import java.util.List;

public class EventualSafeState {

    public static void main(String[] args) {
        int [][] graph = {
                {1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}
        };
        eventualSafeState(graph).forEach(System.out::println);
    }

    private static List<Integer> eventualSafeState( int [][] graph) {
        List<Integer> result = new ArrayList<>();
        int length = graph.length;
        int [] state = new int[length];

        for(int i=0; i < length; i++) {
            if (isSafe(graph,state, i)) {
                result.add(i);
            }
        }

        return result;
    }

    private static boolean isSafe(int [][] graph, int [] state, int current) {
        if(state[current] != 0) {
            return state[current] == 2;
        }
        // currently visiting
        state[current] = 1;

        for(int neighboring : graph[current]) {
            if (!isSafe(graph,state,neighboring)) {
                return false;
            }
        }
        state[current] = 2;
        return true;
    }
}
