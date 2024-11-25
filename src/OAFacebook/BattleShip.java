package OAFacebook;

public class BattleShip {

    public static void main(String[] args) {
        int [] [] grid = {
                {0,0,1},
                {1,0,1}
        };

        System.out.println(totalBattleShipProbability(2,3, grid));
    }

    static double totalBattleShipProbability (int row, int col, int [][] grid) {
        double result = 0.0;
        double totalBattleShip = 0;
        for (int i=0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    totalBattleShip++;
                }
            }
        }

        result = totalBattleShip / (row * col);

        return result;
    }
}
