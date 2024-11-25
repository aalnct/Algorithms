package leetcode.graph.kahn.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ParallelCourses {

    public static void main(String[] args) {
        int n = 4;
        int [][] relation = {
                {1,3},
                {2,3}
        };

        System.out.println(numberOfSemester(n,relation));
    }

    private static int numberOfSemester(int n, int [][] relations) {

        List<Integer>[] adjList = new ArrayList[n+1];
        for (int i=0; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        int [] inDegrees = new int[n+1];

        for (int [] relation : relations) {
            int courseA = relation[0];
            int courseB = relation[1];
            adjList[courseA].add(courseB);
            inDegrees[courseB]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        int [] semester = new int[n+1];
        int maxSemester = 0;

        for(int i=0; i <= n; i++) {
            if (inDegrees[i] == 0) {
                queue.offer(i);
                semester[i] = 1; // set initial semester for course with no prerequisite
            }
        }

        while (!queue.isEmpty()) {
            int currentCourse = queue.poll();
            maxSemester = Math.max(maxSemester,semester[currentCourse]);

            for (int neighbor : adjList[currentCourse]) {
                inDegrees[neighbor]--;
                if (inDegrees[neighbor] == 0) {
                    queue.offer(neighbor);
                    semester[neighbor] = semester[currentCourse] +1; // set semester for the current course
                }
            }
        }

        for (int i=0; i <= n; i++) {
            if (inDegrees[i] > 0) {
                return -1;
            }
        }
        return maxSemester;
    }
}
