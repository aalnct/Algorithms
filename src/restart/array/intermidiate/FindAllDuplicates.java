package restart.array.intermidiate;

import java.util.ArrayList;
import java.util.List;

/**
 *     this question can be solved using HashMap O(n)
 *     but for this there is a restriction that
 *     it has to be solved in O(n) time complexity
 *     and O(1) for space complexity exluding result array
 */
public class FindAllDuplicates {

    public static void main(String[] args) {
        int [] numbers = {4, 3, 2, 7, 8, 2, 3, 1};
        findAllDuplicates(numbers).forEach(System.out::println);
    }

    static List<Integer> findAllDuplicates (int [] numbers) {
        List<Integer> result = new ArrayList<>();

        for (int i=0; i < numbers.length; i++) {
            int num = Math.abs(numbers[i]); // first get the number at the index

            int index = num -1 ; // then use that number as index-1; (since it is 0 index array)

            if (numbers[index] > 0) {
                numbers[index] = -numbers[index];
            } else {
                // this number is negative, means already encountered, so add that to list
                result.add(num);
            }
        }
        return result;
    }

}
