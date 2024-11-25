package restart.array.basic;

public class TotalDistanceTravelled {

    public static void main(String[] args) {
        int mainTank = 5;
        int additionalTank = 10;

        System.out.println(totalDistanceTravelled(mainTank, additionalTank));
    }

    static int totalDistanceTravelled (int mainTank, int additionalTank) {
        int ans = 0;
        int mileage = 10;
        int counter = 0;

        while (mainTank > 0) {
            ans +=mileage; // 10 20 30 40 50 60
            counter++; //1 2 3 4 5 6
            mainTank--; //4 3 2 1 0 0

            if (counter % 5 == 0 && additionalTank > 0) { // true
                mainTank++; // 1
                additionalTank--; // 9
            }
        }
        return ans;  // 60
    }
}
