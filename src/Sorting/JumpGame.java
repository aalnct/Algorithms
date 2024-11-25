package Sorting;

public class JumpGame {

    public static void main(String[] args) {
        int [] array = {2,3,1,1,4};
        System.out.println(canJump(array));

        System.out.println(canJump_2(array));
    }


    public static boolean canJump(int [] array) {
        boolean [] canReach = new boolean[array.length];
        canReach[0] = true; // since we stand at first index (which is 0 right now)

        for (int i=1; i< array.length;i++) { // came back -1, came back -2 (i will be 3), came back - 3 (i will be 4), came back -4 ( i will be 5) ,
                                                // came back here - 5th time (now loop is complete)
            for (int j=0; j<i; j++) { // j will be 0 here , again 0, when the below while loop is false, it will come here, so j will be 1
                                        // j will again be 0
                                        // came back here when false, so j will be 1
                                        // j will again be 0
                                            // came back here when false, j will be 1
                                        // came back here when false, j will be 2
                                            // came back here when false, j will be 3
                                        // came back here when false, j will be 4
                if (canReach[j] && array[j] >= i-j) {  // array[0] (2)>= 1-0 // true, canReach[0] (which is true) && array[0] (2) >= i-j (2-0) --> true
                                                        // canReach[0] = true && array[0] (2) >= (i-j) (3-0) , this time it is false
                                                        // canReach[1] = is true && array[1] (3) >= i-j (3-1) this will be true
                                                        // canReach[0] = is true && array[0] (2) >= (i-j) (4-0) , this will be false
                                                        //canReach[1] = is true && array[1] (3) >= (i-j) (4-1) , this will be true
                                                        // canReach[0] = is true && array[0] (2) >= (i-j) (5-0) , this will be false
                                                        // canReach[1] = is true && array[1] (3) > = (i-j) (5-1) , this will be false
                                                        // canReach[2] = true && array[2] = (1) >= (5-2) , this will be false
                                                        // canReach[3] = is true && array[3] (1) >= (5-3) , this will be false
                                                        // canReach[4] = is true && array[4] (4) >= (i-j) (5-4), this will be true this time
                    canReach[i] = true; // carReach[1] = true , canReach[2] = true , canReach[3] = true, canReach[4] = true, canReach[5] = true
                    break; // now will go back to i loop
                }
            }
        }
        return canReach[array.length-1]; // canReach[5-1] --> canReach[4] which is true // so finally it returned true
    }


    private static boolean canJump_2(int [] nums) { // {2,3,1,1,4};
        int n = nums.length;
        int farthest = 0;

        for (int i = 0; i < n; i++) { // starting i and farthest with 0, i = 1 and farthest = 2, i = 2 and farthest  = 3
            if (i > farthest) { // first iteration, this is false, so continue, false again, false again
                return false; // since current position cannot be reached as it is beyond farthest point
            }

            farthest = Math.max(farthest, i + nums[i]); // 0 = max (0, 0 + nums[0]) --> (0, 2) --> 2
                                                        // 2 = max (2, 1 + nums[1]) --> (2, 4) --> 4
                                                        // 4 = max (4, 2 + nums[2]) --> (4, 3) -- > 4

        }
        return true;
    }
}