package restart.array.basic;

import java.util.HashSet;
import java.util.Set;

public class CheckIfNExists {

    public static void main(String[] args) {
        int [] arr = {10,2,5,3};
        System.out.println(checkIfExists(arr));
    }

    static boolean checkIfExists (int [] array) {
        Set<Integer> seen = new HashSet<>();
        for (int num : array) {
            if (seen.contains(2 * num) || (num % 2 == 0 && seen.contains(num /2))) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }

}
   