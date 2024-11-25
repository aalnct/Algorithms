package restart.gemini.util;

public class MyArrayList {

    private int size = 0;
    private int capacity = 10;
    private Object [] elements;

    public MyArrayList () {
        elements = new Object[capacity];
    }

    public void add (Object element) {
        if (size == capacity) {
            resize();
        }

        elements[size] = element; // adding element at the last index
        size++; // incrementing the size
    }

    private void resize() {
        capacity = capacity * 2;

        Object[] newElements = new Object[capacity];

        for (int i=0; i < size; i++) {
            newElements[i] = elements[i]; // copying to new array
        }

        elements = newElements; // updating the reference
    }

    public Object get (int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index " + index + " size " + size);
        }
        return elements[index];
    }

    public int getSize () {
        return size;
    }

}
