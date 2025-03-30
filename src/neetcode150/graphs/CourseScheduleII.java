package neetcode150.graphs;

import java.util.*;

public class CourseScheduleII {

    public static void main(String[] args) {
        int numCourse = 3;
        int [][] pre = {
                {1,0}
        };
        System.out.println(Arrays.toString(courseScheduleII(numCourse,pre)));
    }

    static int [] courseScheduleII (int numCourses, int [][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int [] inDegrees = new int[numCourses];

        for (int i=0; i < numCourses;i++) {
            graph.add(new ArrayList<>());
        }

        for (int [] pre : prerequisites) {
            int second = pre[0];
            int first = pre[1];

            graph.get(first).add(second);
            inDegrees[second]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i=0; i < numCourses; i++) {
            if (inDegrees[i] == 0) {
                queue.offer(i);
            }
        }

        int [] courseTaken = new int[numCourses];
        int index = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            courseTaken[index++] = current;

            for (int nei : graph.get(current)) {
                inDegrees[nei]--;
                if (inDegrees[nei] == 0) {
                    queue.offer(nei);
                }
            }
        }

        if (index != numCourses) {
            return new int [0];
        }

        return courseTaken;
    }
}
