package ds.leetcode.StringSolutions;

/**
 * Created by AmitAgarwal on 6/24/20.
 */
public class StudentsDoingHomework {

    public static void main(String[] args) {
        int[] startTime = new int [] {9,8,7,6,5,4,3,2,1};
        int[] endTime = new int[] {10,10,10,10,10,10,10,10,10};
        int queryTime = 5;

        int count = busyStudent(startTime,endTime,queryTime);
        System.out.println(count);
    }

    public static int busyStudent(int[] s1, int[] s2, int queryTime){
        int count = 0;
        for(int i=0;i<s2.length;i++){
            if(s1[i] <= queryTime && s2[i]>queryTime){
                count++;
            }
        }
        return count;
    }
}
