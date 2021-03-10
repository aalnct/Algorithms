package fb;

public class MoveZerosToLeft {

    public static void main(String[] args) {
        int []  array = new int[] {1,10,20,0,59,63,0,88,0};
        array = moveZerosToLeft(array);
        for (int i : array) {
            System.out.print(i + " | ");
        }
    }

    static int[] moveZerosToLeft (int [] array) {
        int length = array.length;
        int read_idex = array.length-1;
        int write_index = array.length-1;

        for (int i = 0; i < length; i++) {
            if (array[read_idex] == 0) {
                read_idex --;
                continue;
            } else {
                int temp = array[write_index];
                array[write_index] = array[read_idex];
                array[read_idex] = temp;
                write_index--;
                read_idex--;
            }
        }

        return array;
    }
}
