package restart.gemini.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class CourseSchedule {

    /**
     * Have to find out if all course can be taken
     * this is graph based problem
     * have to maintain edges, and those edges become 0, that is all pre-requisites are taken
     * then take the course
     * in the end number of course should match total course takes for it to be 'true'
     */

    public static void main(String[] args) {
        int numOfCourse = 2;
        int [][] prerequisites = {
                {1,0}
        };
        System.out.println(courseSchedule(numOfCourse,prerequisites));
    }

    static boolean courseSchedule (int numOfCourse, int [][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();
        int [] incoming = new int[numOfCourse];

        for (int i=0; i < numOfCourse; i++) {
            graph.add(new ArrayList<>());
        }

        for (int [] pre : prerequisites) {
            int course = pre[0];
            int before = pre[1];

            incoming[course]++;
            graph.get(before).add(course); // first take before and then go to course
        }

        // only add into queue when all the pre-requisites for that course are taken
        Queue<Integer> queue = new ConcurrentLinkedQueue<>();
        for (int i=0; i < numOfCourse; i++) {
            if (incoming[i] == 0) queue.offer(i);
        }

        // if queue is not empty here that means there are no course
        // that does not have any pre-requisites, so it is a never ending loop
        // so just return false at this point
        int courseTaken = 0;
        while (!queue.isEmpty()) {
            int currentCourse = queue.poll();
            courseTaken++;

            for (int neighbour : graph.get(currentCourse)) {
                incoming[neighbour]--;
                if (incoming[neighbour] == 0) {
                    queue.offer(neighbour);
                }
            }
        }
        return courseTaken == numOfCourse;
    }
}
