package ds.leetcode.BinarySearchProblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by AmitAgarwal on 5/16/20.
 */
public class FindPositiveInteger {

    public static void main(String[] args) {
        int z = 90;
        List<List<Integer>> list = findSolution(z);
        list.forEach(s-> System.out.println(s));

    }

    private static List<List<Integer>> findSolution(int target){
        List<List<Integer>> result = new ArrayList<>();
        int value = 0;
        int lastHigh = target;
        int mid = 0;

        for(int index = 1; index<=target;index++){
            int low = 1;
            int high = lastHigh;

            while(low <= high){
                mid = (high-low)/2;

            }
        }
        return null;
    }
}
