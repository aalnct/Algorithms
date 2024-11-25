package leetcode.top_150;

public class JumpGame2 {
    public static void main(String[] args) {
        int [] jumpGame = {2, 3, 1, 1, 4};
        System.out.println(jumpGame(jumpGame));
    }

    private static int jumpGame(int [] jumpGame) {
        int n = jumpGame.length;
        int farthestJump = 0;
        int currentJumpEnd = 0;
        int jumps = 0;

        for(int i=0; i < n-1 ; i++) {
            farthestJump = Math.max(farthestJump, i + jumpGame[i]);

            if(i == currentJumpEnd) {
                jumps++;
                currentJumpEnd = farthestJump;

                if(currentJumpEnd >= n-1) {
                    break;
                }
            }
        }
        return jumps;
    }
}
