package restart.graph.medium;

import java.util.*;

public class CourseSchedule2 {

    public static void main(String[] args) {
        int numCourses = 4;
        int [][] prerequisites = {
                {1, 0},
                {2, 0},
                {3, 1},
                {3, 2}
        };
        System.out.println(Arrays.toString(courseSchedule(numCourses,prerequisites)));
    }

    private static int [] courseSchedule (int numCourses, int [][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i=0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        int [] inDegrees = new int[numCourses];

        for (int [] pre : prerequisites) {
            int course = pre[0]; // {0,1} -- so the course we have to take is 0
            int prereq = pre[1]; // but to take 0, we will have to take 1 first

            graph.get(prereq).add(course);
            inDegrees[course]++; // this shows pre before any course can be taken
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i < numCourses; i++) {
            if (inDegrees[i] == 0) {
                queue.offer(i);
            }
        }

        int [] order = new int[numCourses];
        int index = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            order[index++] = current;

            for (int neighbour : graph.get(current)) {
                inDegrees[neighbour]--; // decrement so that it can become 0
                if (inDegrees[neighbour] == 0) {
                    queue.offer(neighbour);
                }
            }
        }

        if ( index == numCourses ) {
            return order;
        } else {
            return new int [0];
        }
    }
}
