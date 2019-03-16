package pl.sda.programming1.datastructures;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class FixedSizeSdaHeap<T extends Comparable<T>> implements SdaHeap<T> {

    private T[] heap;
    private int size;

    public FixedSizeSdaHeap(T[] heap, int capacity) {
        this.heap = Arrays.copyOf(heap, capacity);
        this.size = heap.length;
    }

    @Override
    public void push(T element) {
        if (size == heap.length) {
            throw new IllegalStateException("Heap is full. You cannot add element!");
        }
        heap[size] = element;
        shiftUp(size);
        size++;
    }

    private void shiftUp(int i) {
        if (i == 0) {
            return;
        }
        int parent = (i - 1) / 2;
        T parentValue = heap[parent];
        T childValue = heap[i];
        if (parentValue.compareTo(childValue) < 0) {
            swap(parent, i);
            shiftUp(parent);
        }
    }

    private void swap(int parent, int i) {
        T temp = heap[i];
        heap[i] = heap[parent];
        heap[parent] = temp;
    }

    @Override
    public T pop() {
        if (size == 0) {
            throw new NoSuchElementException("Heap is empty!");
        }
        T element = heap[0];
        heap[0] = null;
        size--;
        swap(0, size);
        shiftDown(0);
        return element;
    }

    private void shiftDown(int i) {
        int largest = i;

        int left = 2 * i + 1;
        if (left < heap.length && heap[left] != null && heap[left].compareTo(heap[largest]) > 0) {
            largest = left;
        }

        int right = 2 * i + 2;
        if (right < heap.length && heap[right] != null && heap[right].compareTo(heap[largest]) > 0) {
            largest = right;
        }

        if (i != largest) {
            swap(i, largest);
            shiftDown(largest);
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T[] toArray() {
        return Arrays.copyOf(heap, size);
    }
}
