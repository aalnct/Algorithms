package restart.gemini.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class CourseScheduleII {

    public static void main(String[] args) {
        int numOfCourse = 4;
        int [][] prerequisites = {
                {1,0},
                {2,0},
                {3,1},
                {3,2}
        };
        System.out.println(Arrays.toString(courseSchedule(numOfCourse,prerequisites)));
    }

    static int [] courseSchedule (int numOfCourse, int [][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int [] incoming = new int[numOfCourse];

        for (int i=0; i < numOfCourse; i++) {
            graph.add(new ArrayList<>());
        }

        for (int [] pre : prerequisites) {
            int course = pre[0];
            int before = pre[1];

            graph.get(before).add(course);
            incoming[course]++;
        }

        Queue<Integer> queue = new ConcurrentLinkedQueue<>();
        for (int i=0; i < numOfCourse; i++) {
            if (incoming[i] == 0) {
                queue.offer(i);
            }
        }

        int [] order = new int[numOfCourse];
        int index = 0;
        while (!queue.isEmpty()) {
            int currentCourse = queue.poll();
            order[index++] = currentCourse;

            for (int neighbour : graph.get(currentCourse)) {
                incoming[neighbour]--;
                if (incoming[neighbour] == 0) {
                    queue.offer(neighbour);
                }
            }
        }

        if (index == numOfCourse) {
            return order;
        } else {
            return new int[0];
        }
    }
}
