package OAGoogle.binarysearch;

public class SmallestGreaterThanTarget {

    public static void main(String[] args) {
        char [] letters = {'c','f','l'};
        char target = 'a';

        System.out.println(smallestGreaterThanTarget(letters,target));
    }

    static char smallestGreaterThanTarget (char [] letters, char target) {
        int left = 0;
        int right = letters.length-1;

        while (left <= right) {
            int pivot = left + (right - left) /2;

            if (letters[pivot] <= target) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }
        return left == letters.length ? letters[0] : letters[left];
    }
}
