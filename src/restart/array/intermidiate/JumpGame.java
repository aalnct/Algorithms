package restart.array.intermidiate;

public class JumpGame {

    public static void main(String[] args) {
        int [] arr = {2,3,1,1,4};
        int n = 6;
        System.out.println(jumpGame(arr,n));
    }

    static int jumpGame (int [] arr, int n) {
        int jump = 0; // how many jumps needed
        int farthest = 0; // how far will i reach after current jump
        int currentEnd = 0;

        for (int i=0; i < n-1; i++) {
            farthest = Math.max(farthest,i+arr[i]);

            if (i == currentEnd) {
                jump++;
                currentEnd = farthest;

                if (currentEnd >= n-1) {
                    return jump;
                }
            }
        }
        return currentEnd >= n-1 ? jump : -1;
    }
}
