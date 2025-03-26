package restart.graph.medium;

public class FindChampions2 {

    public static void main(String[] args) {
        int n = 3;
        int[][] matches1 = {{0,1}, {1, 2}};

        System.out.println(findChampion(n,matches1));
    }


    static int findChampion (int n, int [][] matches) {
        int [] loserCount = new int[n+1];

        for (int [] match : matches) {
            int winner = match[0]; // winner of that match
            int loser = match[1]; // loser of that match
            loserCount[loser]++;
        }

        int champion = -1;
        for (int i=1; i <= n; i++) {
            if (loserCount[i] == 0) {
                if (champion == -1) {
                    champion = i;
                } else {
                    return -1;
                }
            }
        }
        return champion;
    }
}
