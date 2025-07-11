package restart.array.intermidiate.two_pointer;

import java.util.Arrays;

public class MinimumBoats {

    public static void main(String[] args) {
        int [] people = {3,2,2,1};
        int limit = 3;

        System.out.println(minimumBoats(people,limit));
    }

    static int minimumBoats (int [] people, int limit) {

        Arrays.sort(people);

        int left = 0;
        int right = people.length-1;
        int boats = 0;

        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }
            right--; // heaviest person always get on the boat
            boats++;
        }
        return boats;
    }
}