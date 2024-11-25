package Sorting;

public class Application {


    public static void main(String[] args) {
        Heap newHeap = new Heap(10);
        newHeap.insertIntoHeap(10);
        newHeap.insertIntoHeap(12);
        newHeap.insertIntoHeap(42);
        newHeap.insertIntoHeap(35);
        newHeap.insertIntoHeap(16);
        newHeap.insertIntoHeap(88);
        newHeap.insertIntoHeap(42);
        newHeap.insertIntoHeap(7);
    }
}
