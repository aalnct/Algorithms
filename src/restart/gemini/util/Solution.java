package restart.gemini.util;

public class Solution {

    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add("Element 1");
        myArrayList.add("Element 2");
        myArrayList.add("Element 3");


        System.out.println("Size " + myArrayList.getSize()) ;
        System.out.println("Element at index 0 :" + myArrayList.get(0));
        System.out.println("Element at index 1 :" + myArrayList.get(1));
    }
}
