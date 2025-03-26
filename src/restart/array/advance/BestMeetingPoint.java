package restart.array.advance;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BestMeetingPoint {
    public static void main(String[] args) {
        int [][] grid = {
                {1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0}
        };

        System.out.println(bestMeetingPoint(grid));
    }

    static int bestMeetingPoint (int [][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        List<Integer> xCoordinates = new ArrayList<>();
        List<Integer> yCoordinates = new ArrayList<>();

        for (int i=0; i < rows; i++) {
            for (int j=0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    xCoordinates.add(i); // filling x coordinates
                }
            }
        }

        for (int j=0; j < cols; j++) {
            for (int i=0; i < rows; i++) {
                if (grid[i][j] == 1) {
                    yCoordinates.add(j); // filling y coordinates
                }
            }
        }

        int xMedian = xCoordinates.get(xCoordinates.size()/2);
        int yMedian = yCoordinates.get(yCoordinates.size()/2);

        int totalDistance = 0;
        for (int x : xCoordinates) {
            totalDistance += Math.abs(x - xMedian);
        }

        for (int y : yCoordinates) {
            totalDistance += Math.abs(y - yMedian);
        }

        return totalDistance;
    }
}
