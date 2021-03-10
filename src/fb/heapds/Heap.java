package fb.heapds;

public class Heap {

    // heap array
    private Node[] heapArray;

    //max size of an array
    private int maxSize;

    // current size
    private int currentSize;

    public Heap(int maxSize) {
        this.maxSize = maxSize;
        currentSize = 0;
    }

    // whether we were able to insert it or not
    public boolean insertIntoHeap(int key) {
        if (currentSize == maxSize) {
            return false;
        }

        trickle(currentSize); // heapify
        currentSize++;
        return true;
    }

    private void trickle (int index) { // will pass the index where data needs to be inserted
        int parentIndex = (index-1)/2; // formula for getting parent index --> (n-1)/2
        Node nodeToInsert = heapArray[index];

        while (index >=0 && heapArray[parentIndex].getKey() <
                nodeToInsert.getKey()) {
            heapArray[index] = heapArray[parentIndex];
            index = parentIndex;
            parentIndex = (parentIndex-1)/2;
        }

        heapArray[index] = nodeToInsert;
    }

}
