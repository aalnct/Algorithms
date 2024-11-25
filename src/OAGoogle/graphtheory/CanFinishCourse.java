package OAGoogle.graphtheory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CanFinishCourse {

    public static void main(String[] args) {
        int num = 2;
        int [][] pre = new int [][] {
                {1,0}
        };
        System.out.println(canFinishCourse(num,pre));
    }
    static boolean canFinishCourse (int numOfCourse, int [][] prerequisite) {

        // first I need a degree of course (to maintain total number of courses)

        int [] inDegree = new int[numOfCourse];

        // adjacency list ...
        List<List<Integer>> graph = new ArrayList<>();

        for (int i=0; i < numOfCourse; i++) {
            graph.add(new ArrayList<>());
        }

        for (int [] pre : prerequisite) {
            int course = pre[0];
            int preCourse = pre[1]; // this needs to be done before course ...

            graph.get(preCourse).add(course); // this means finish preCourse and then take course ...
            inDegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        // we will add course 0 to queue ...
        for (int i=0; i < numOfCourse; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        // topological sorting ...

        int completedCourse = 0;
        while (!queue.isEmpty()) {
            int currentCourse = queue.poll();
            completedCourse++; // taken current course

            for (int nextCourse : graph.get(currentCourse)) {
                inDegree[nextCourse]--;
                if (inDegree[nextCourse] == 0) {
                    queue.add(nextCourse);
                }
            }
        }
        return completedCourse == numOfCourse;
    }
}