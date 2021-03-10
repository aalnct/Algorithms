package fb;

import java.util.Stack;

public class MergeIntervals {


    public static void main(String[] args) {
        Interval in [] = new Interval[4];
        in[0] = new Interval(1,5);
        in[1] = new Interval(3,7);
        in[2] = new Interval(4,6);
        in[3] = new Interval(6,8);

        mergeIntervals(in);
    }

    static void mergeIntervals (Interval[] array) {
        Stack<Interval> stack = new Stack<>();
        stack.push(array[0]);

        for (int i = 0; i < array.length; i++) {
            Interval top = stack.peek();

            if (top.end < array[i].start) {
                stack.push(array[i]);
            }
            else if (top.end < array[i].end) {
                top.end = array[i].end;
                stack.pop();
                stack.push(top);
            }
        }

        while (!stack.isEmpty()) {
            Interval t = stack.pop();
            System.out.println("[" + t.start + "," + t.end + "]");
        }
    }
}

class Interval {
    int start;
    int end;

    Interval (int start, int end) {
        this.start = start;
        this.end = end;
    }
}
