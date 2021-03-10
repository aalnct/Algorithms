package fb;

public class DutchFlagProblem {

    public static void main(String[] args) {
        char[] balls = new char[] {'G', 'B', 'G', 'G', 'R', 'B', 'R', 'G'};
        dutchFlag(balls);

        for (char c : balls) {
            System.out.println(c);
        }
    }

    public static void dutchFlag(char[] balls) {
        quickSort(balls, 0, balls.length-1);
    }

    static void quickSort(char[] balls, int start, int end) {
        if (start <= end) {
            int partitionPoint = getPartitionPoint(balls, start,end);
            quickSort(balls, start, partitionPoint-1);
            quickSort(balls,partitionPoint+1,end);
        }
    }

    static int getPartitionPoint(char[] balls, int start, int end) {
        int pivot = balls[end];
        int i = start-1; // will start from -1

        for (int j = start; j< end;j++) {
            if (balls[j] > pivot) {
                i++;
                char temp = balls[i];
                balls[i] = balls[j];
                balls[j] = temp;
            }
        }

        char temp = balls[i+1];
        balls[i+1] = balls[end];
        balls[end] = temp;

        return i+1;
    }
}
