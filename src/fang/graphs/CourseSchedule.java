package fang.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {

    public static void main(String[] args) {
        int numCourses = 2;
        int [][] prerequisites = {{
            1,0
        }};
        System.out.println(courseSchedule(numCourses,prerequisites));
    }

    static boolean courseSchedule (int numCourses, int [][] prerequisites) {
        int [] incomingCourses = new int[numCourses];

        List<List<Integer>> graph = new ArrayList<>();

        for (int i=0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int [] pre : prerequisites) {
            int course = pre[0];
            int preCourse = pre[1];

            incomingCourses[course]++; // this is to represent how many prerequisite course has

            graph.get(preCourse).add(course);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i < numCourses; i++) {
            if (incomingCourses[i] == 0) {
                queue.offer(i); // only add course if all prerequisites are done
            }
        }

        int courseTaken = 0;
        while (!queue.isEmpty()) {
            int currentCourse = queue.poll();
            courseTaken++;

            for (int neighbour : graph.get(currentCourse)) {
                incomingCourses[neighbour]--;
                if (incomingCourses[neighbour] == 0) {
                    queue.offer(neighbour);
                }
            }
        }
        return courseTaken == numCourses;
    }
}
