package leetcode.graph.kahn.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// below is using BFS
public class CourseSchedule {

    public static void main(String[] args) {
        int numCourse = 2;
        int [][] prerequisite = {
                {1,0},
                {0,1}
        };
        System.out.println(canFinishCourses(numCourse,prerequisite));
    }

    private static boolean canFinishCourses(int numCourses, int [][] prerequisite) {

        int [] inComingCourse = new int[numCourses];

        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for(int [] pre : prerequisite) {
            int course = pre[0];
            int preCourse = pre[1];
            inComingCourse[course]++;

            graph.get(preCourse).add(course);
        }

        Queue<Integer> queue = new LinkedList<>();

        // only add into queue if there is no prerequisite for the course left ...
        for(int i=0; i < numCourses; i++) {
            if (inComingCourse[i] == 0) {
                queue.offer(i);
            }
        }

        int courseTaken = 0;
        while(!queue.isEmpty()) {
            int currentCourse = queue.poll();
            courseTaken++;

            for (int neighbor : graph.get(currentCourse)) {
                inComingCourse[neighbor]--;
                if (inComingCourse[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return courseTaken == numCourses;
    }

}
