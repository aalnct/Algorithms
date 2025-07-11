package restart.array.intermidiate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class FindKClosestElements {

    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5};
        int k = 4;
        int x = 3;

        findClosestElements(arr,k,x).forEach(System.out::println);
        findClosestElementsUsingPriorityQueue(arr,k,x).forEach(System.out::println);
    }

    static List<Integer> findClosestElements (int [] arr, int k, int x) {
        List<int []> elements = new ArrayList<>();

        for (int number : arr) {
            int distance = Math.abs(number - x);
            elements.add(new int [] {number,distance});
        }

        // sort by distance and if distance is same for two elements, sort by value
        elements.sort((a,b) -> {
            if (a[1] != b[1]) {
                return a[1] - b[1]; // sort by distance
            }
            return a[0] - b[0]; // if distance are equal, we are sorting by value
        });

        List<Integer> result = new ArrayList<>();
        for (int i=0; i < k; i++) {
            result.add(elements.get(i)[0]);
        }
        Collections.sort(result);

        return result;
    }


    static List<Integer> findClosestElementsUsingPriorityQueue (int [] arr, int k, int x) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>( (a,b) -> {
            int distanceA = Math.abs(a-x);
            int distanceB = Math.abs(b-x);

            if (distanceA != distanceB) {
                return distanceB - distanceA; // sort by distance
            }

            return b-a; // sort by value
        });

        for (int number : arr) {
            maxHeap.offer(number);

            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        List<Integer> res = new ArrayList<>(maxHeap);
        Collections.sort(res);

        return res;
    }
}
