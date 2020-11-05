package ds.leetcode.hashtable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by AmitAgarwal on 6/22/20.
 */
public class Intersection {

    public static void main(String[] args) {
        int[] nums1 = new int [] {4,9,5};
        int[] nums2 = new int [] {9,4,9,8,4};
        int[] output = intersection(nums1,nums2);
        for(int n : output){
            System.out.println(n);
        }
    }

    public static int[] intersection(int[] nums1, int[] nums2){
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();

        for(int n : nums1){
            s1.add(n);
        }
        for(int n : nums2){
            s2.add(n);
        }

        if(s1.size() < s2.size()){
            return set_intersection(s1, s2);
        }else {
            return set_intersection(s2, s1);
        }
    }

    public static int[] set_intersection(Set<Integer> s1, Set<Integer> s2){
        int[] output = new int[s1.size()];
        int id = 0;
        for(Integer s : s1){
            if(s2.contains(s)){
                output[id++] = s;
            }
        }
        return Arrays.copyOf(output,id);
    }
}
