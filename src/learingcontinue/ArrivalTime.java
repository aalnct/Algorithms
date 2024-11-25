package learingcontinue;

public class ArrivalTime {


    public static void main(String[] args) {
        int newTime= arrivalTime(1, 24);
        System.out.println(newTime);
    }

    static int arrivalTime(int arrivalTime, int delayedTime) {

        int newTime = (arrivalTime + delayedTime) % 24;

        if (newTime < 0) {
            newTime +=24;
        }

        return newTime;
    }

}
