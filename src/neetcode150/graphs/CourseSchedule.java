package neetcode150.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {

    public static void main(String[] args) {
        int num = 2;
        int [][] pre = {
                {0,1}
        };
        System.out.println(courseSchedule(num,pre));
    }

    /**
     *    Checking if all courses can be taken or not
     *
     *    before taking course 0, you need to take course 1 --> pre[0,1]
     */

    static boolean courseSchedule (int num, int [][] prerequisites) {
        int courseTaken = 0;

        int [] inDegree = new int[num];

        List<List<Integer>> adjList = new ArrayList<>();

        for (int i=0; i <num; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int [] pre : prerequisites) {
            int second = pre[0];
            int first = pre[1];

            adjList.get(first).add(second);
            inDegree[second]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i=0; i <num; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }


        while (!queue.isEmpty()) {
            int current = queue.poll();
            courseTaken++;

            for (int nei : adjList.get(current)) {
                inDegree[nei]--;
                if (inDegree[nei] == 0) {
                    queue.offer(nei);
                }
            }
        }

        return courseTaken == num;
    }
}
