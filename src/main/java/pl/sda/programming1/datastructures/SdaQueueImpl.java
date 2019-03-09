package pl.sda.programming1.datastructures;

import java.util.Optional;

public class SdaQueueImpl<T> implements SdaQueue<T> {

    private Node<T> first;
    private Node<T> last;

    @Override
    public void enqueue(T element) {
        Node<T> node = new Node<>(element);
        if (last == null) {
            last = node;
            first = node;
        } else {
            last.next = node;
            last = node;
        }
    }

    @Override
    public Optional<T> dequeue() {
        if (isEmpty()) {
            return Optional.empty();
        } else {
            Node<T> x = first;
            first = first.next;
            if (isEmpty()) {
                last = null;
            }
            return Optional.of(x.value);
        }
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public Optional<T> peek() {
        if (isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(first.value);
        }
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
        }
    }

}