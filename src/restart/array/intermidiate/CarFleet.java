package restart.array.intermidiate;


import java.util.Arrays;
import java.util.Date;
import java.util.Stack;

class Car {

    int position;
    double time;

    public Car (int position, double time) {
        this.position = position;
        this.time = time;
    }
}
public class CarFleet {

    public static void main(String[] args) {
        int target = 12;
        int[] position = {10, 8, 0, 5, 3};
        int[] speed = {2, 4, 1, 1, 3};

        System.out.println(carFleet(target,position,speed));
    }

    static int carFleet (int target, int [] position, int [] speed) {

        int length = position.length;
        Car [] car = new Car[length];

        // create an array of cars that will have each car
        // with their position and time it will take it to reach destination
        for (int i=0; i < length; i++) {
            car[i] = new Car(position[i], (double) (target - position[i])/speed[i]);
        }

        // now lets sort all those cars created above based on their distance from target
        Arrays.sort(car, (a,b) -> Integer.compare(b.position,a.position));

        // now comes stack that will have fleets based on their speed
        // if speed is same, fleet is same, if speed is less, than that forms a new fleet
        Stack<Double> stack = new Stack<>();
        for (Car c : car) {
            if (stack.isEmpty() || c.time > stack.peek()) {
                stack.push(c.time);
            }
        }

        return stack.size();
    }

}
