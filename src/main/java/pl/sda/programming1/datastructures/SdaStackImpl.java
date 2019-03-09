package pl.sda.programming1.datastructures;

import java.util.Optional;

public class SdaStackImpl<T> implements SdaStack<T> {

    private Node<T> top;

    @Override
    public void push(T element) {
        if (isEmpty()) {
            top = new Node<>(element);
        } else {
            Node<T> node = new Node<>(element);
            node.bottomNext = top;
            top = node;
        }
    }

    @Override
    public Optional<T> pop() {
        if (isEmpty()) {
            return Optional.empty();
        } else {
            Optional<T> topValue = Optional.of(top.value);
            top = top.bottomNext;
            return topValue;
        }
    }

    @Override
    public Optional<T> peek() {
        if (isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(top.value);
        }
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    private static class Node<T> {
        T value;
        Node<T> bottomNext;

        private Node(T value) {
            this.value = value;
        }
    }

}
