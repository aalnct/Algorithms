package leetcode.graph.kahn.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

// the below is using the DFS approach
public class CourseSchedule2 {

    public static void main(String[] args) {
        int numberOfCourse = 4;
        int [][] preRequisite = {
                {1,0},
                {2,0},
                {3,1},
                {3,2}
        };

        System.out.println(Arrays.toString(courseScheduleOrder(numberOfCourse,preRequisite)));
    }

    private static int[] courseScheduleOrder(int numCourses, int [][] prerequisite) {
        List<Integer>[] adjacencyList = new ArrayList[numCourses];

        for (int i=0; i < numCourses; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int [] pre: prerequisite) {
            adjacencyList[pre[1]].add(pre[0]); // complete course at index 1 to take course at index 0
        }

        Stack<Integer> stack = new Stack<>();
        boolean [] visited = new boolean[numCourses];
        boolean [] recStack = new boolean[numCourses];

        // here we will check if there is a cycle in graph
        for (int i=0; i <numCourses; i++) {
            if (!visited[i] &&
            isCyclic(i, adjacencyList, visited,recStack,stack)) {
                return new int[0]; // if there is a cycle return empty array since all course cannot be taken
            }
        }

        int[] result = new int[numCourses];
        for (int i=0; !stack.isEmpty(); i++) {
            result[i] = stack.pop();
        }
        return result;
    }

    private static boolean isCyclic(int currentCourse, List<Integer>[] adjList, boolean [] visited,
                                    boolean [] recStack, Stack<Integer> stack) {

        visited[currentCourse] = true;
        recStack[currentCourse] = true;

        for (int neighbor : adjList[currentCourse]) {
            if (!visited[neighbor]) {
                if (isCyclic(neighbor,adjList,visited,recStack,stack)) {
                    return true;
                }
            } else if (recStack[neighbor]) {
                return true; // cycle detected
            }
        }

        recStack[currentCourse] = false; // this step is necessary to backtrack so that we can explore all its neighbor
        stack.push(currentCourse);
        return false;
    }
}
