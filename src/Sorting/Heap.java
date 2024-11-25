package Sorting;

public class Heap {
    private HeapNode [] heapArray;
    private int maxSize; // size of the array
    private int currentSize; // number of nodes in array

    public Heap (int size) {
        this.maxSize = size;
        currentSize = 0; // when we initialize heap array it will be empty
        heapArray = new HeapNode[size]; // actually create the array
    }

    // helper methods
    public int getSize() {
        return currentSize;
    }

    public boolean isEmpty() {
        return (currentSize == 0);
    }

    public boolean insertIntoHeap(int key) {
        if (currentSize == maxSize) {
            return false; // array is full
        }

        HeapNode newNode = new HeapNode(key);
        heapArray[currentSize] = newNode;

        // method where we insert the key at the correct position
        trickleUp(currentSize);

        currentSize++;
        return true;
    }

    private void trickleUp (int index) {
        // find the parent index of the current index
        int parentIndex = (index-1)/2;

        HeapNode nodeToInsert = heapArray[index];

        // loop as long as we have not reached the root index
        // and child key node is smaller/less than parent key node

        while (index > 0 && heapArray[parentIndex].getKey() < nodeToInsert.getKey()) {
            heapArray[index] = heapArray[parentIndex];
            index = parentIndex;
            parentIndex = (parentIndex-1)/2;
        }

        heapArray[index] = nodeToInsert;
    }

    // delete the key and trickleDown (largest child gets swapped with the parent)
    public HeapNode removeNode () {
        HeapNode root = heapArray[0];
        // replace root with all the way to the bottom key node
        heapArray[0] = heapArray[--currentSize]; // we are assigning the last element in the heap to the root
        trickleDown(0); // start from 0 index

        return root;
    }

    private void trickleDown (int index) {
        int largeChildIndex;
        HeapNode top = heapArray[index]; // save last into top variable

        // will run as long as index (idx) is not on the bottom row (at leat 1 child)

        while (index < currentSize/2) {
            // get the left and right child using the formula
            int leftChild = 2*index + 1;
            int rightChild = 2 * index + 2; // or you can say rightChild = leftChild + 1

            // figure out which child is larger
            if (rightChild < currentSize &&
                heapArray[leftChild].getKey() < heapArray[rightChild].getKey()) {
                largeChildIndex = rightChild;
            } else {
                largeChildIndex = leftChild;
            }
            if (top.getKey() >= heapArray[largeChildIndex].getKey()) {
                // made root the largest key
                break;
            }
            heapArray[index] = heapArray[largeChildIndex];
            index = largeChildIndex;
        }

        heapArray[index] = top;
    }
}
