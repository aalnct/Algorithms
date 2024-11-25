package leetcode.top_150;

public class RemoveElements {
    public static void main(String[] args) {
        int [] array = {3,2,2,3};
        int value = 3;
        System.out.println(removeElements(array,value));
    }

    private static int removeElements(int [] array, int value) {
        int length = array.length;

        if(length == 0) {
            return 0;
        }

        int increment = 0;

        for(int i=0; i < length; i++) {
            if(array[i] != value) {
                array[increment] = array[i];
                increment++;
            }
        }
        return increment++;
    }
}
