package leetcode.binarysearch;

public class NextGreatestCharacter {

    public static void main(String[] args) {
        char [] letters = {'a','b','c','e'};
        char target = 'd';

        System.out.println(nextGreatestLetter(letters,target));
    }

    private static char nextGreatestLetter(char [] letter, char target) {
        int left = 0;
        int right = letter.length-1;

        while (left <= right) {
            int mid = left + (right - left)/2;
            if (letter[mid] < target) {
                left =  mid  + 1;
            } else {
                right = mid - 1;
            }
        }

        return left == letter.length ? letter[0] : letter[left];
    }
}
