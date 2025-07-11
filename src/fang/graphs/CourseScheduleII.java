package fang.graphs;

import java.util.*;

public class CourseScheduleII {

    public static void main(String[] args) {
        int numCourses = 2;
        int [][] prerequisites = {{
                1,0
        }};
        System.out.println(Arrays.toString(courseScheduleOrder(numCourses, prerequisites)));
    }

    static int [] courseScheduleOrder (int numCourses, int [][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int [] incoming = new int[numCourses];

        for (int i=0; i <numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int [] pre : prerequisites) {
            int course = pre[0];
            int preCourse = pre[1];

            incoming[course]++;

            graph.get(preCourse).add(course);
        }

        int [] order = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();

        for (int i=0; i < numCourses; i++) {
            if (incoming[i] == 0) {
                queue.offer(i);
            }
        }

        int index = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            order[index++] = current;

            for (int nei : graph.get(current)) {
                incoming[nei]--;
                if (incoming[nei] == 0) {
                    queue.offer(nei);
                }
            }
        }

        if (index == numCourses) {
            return order;
        } else {
            return new int[0];
        }
    }
}
