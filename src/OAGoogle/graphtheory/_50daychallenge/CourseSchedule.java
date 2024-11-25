package OAGoogle.graphtheory._50daychallenge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {

    public static void main(String[] args) {
        int numCourse = 2;
        int [][] preRequisite = {
                {1,0}
        };
        System.out.println(canFinish(numCourse,preRequisite));
    }

    private static boolean canFinish(int numCourses, int[][] prerequisite) {

        // initialize an array inComing array to keep track of incoming edges (pre-requisite)
        // for each course

        int [] inComingCourses = new int[numCourses];

        // initialize an adjacency list graph to represent the course pre-requisite
        // each course is a node, and its pre-requisite are represented as edges in the list

        List<List<Integer>> graph = new ArrayList<>();

        // Iterate through the num of courses and build adjacency list

        for (int i=0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // we will iterate through the prerequisite array and build its edges and nodes

        for (int [] pre : prerequisite) {
            int course = pre[0];
            int preCourse = pre[1];
            inComingCourses[course]++; // this will represent how many prerequiste course has

            // this below line will establish a direct link to course, means
            // first take preCourse and then take course ....
            graph.get(preCourse).add(course);
        }

        // create a queue, and then check if the given course in the loop has no prerequisite, i.e. it is 0

        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i< numCourses; i++) {
            if (inComingCourses[i] == 0) {
                queue.offer(i);
            }
        }

        int coursesTaken = 0;
        while (!queue.isEmpty()) {
            int currentCourse = queue.poll();
            coursesTaken++;

            for (int neighbour : graph.get(currentCourse)) {
                inComingCourses[neighbour]--;
                if (inComingCourses[neighbour] == 0) {
                    queue.offer(neighbour);
                }
            }
        }

        return coursesTaken == numCourses;
    }
}
