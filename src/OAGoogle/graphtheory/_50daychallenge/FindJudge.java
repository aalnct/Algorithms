package OAGoogle.graphtheory._50daychallenge;

public class FindJudge {

    public static void main(String[] args) {
        int [][] trust =  { {1,2} };
        int n = 2;
        System.out.println(findJudge(n,trust));
    }

    // the person that has n-1 trust count is the judge ...
    static int findJudge (int n, int [][] trust) {
        int [] trustCount = new int[n+1];

        for (int [] pair : trust) {
            int personA = pair[0];
            int personB = pair[1];

            trustCount[personA]--;
            trustCount[personB]++;
        }

        for (int i=1; i <= n; i++) {
            if (trustCount[i] == n-1) {
                return i;
            }
        }
        return -1;
    }
}
