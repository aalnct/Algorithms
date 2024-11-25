package restart.array.basic;

public class MajorityElement {

    public static void main(String[] args) {
        int []  array = {1,2,3};
        System.out.println(majorityElement(array));
    }

    static int majorityElement (int [] array) {
        Integer candidate = findCandidate(array);
        if (candidate != null && isMajorityElement (array,candidate)) {
            return candidate;
        }
        return -1;
    }

    static Integer findCandidate(int [] array) {
        Integer candidate = null;
        int count = 0;

        for (int num : array) {
            if (count == 0) {
                candidate = num;
            }
            count = count + ((candidate == num) ? 1 : -1);
        }
        return candidate;
    }

    static boolean isMajorityElement (int [] arrary, int candidate) {
        int count = 0;
        for(int num : arrary) {
            if (num == candidate) {
                count++;
            }
        }
        return count > arrary.length/2;
    }

}
