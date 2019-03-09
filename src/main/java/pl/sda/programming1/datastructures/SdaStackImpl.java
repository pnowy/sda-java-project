package pl.sda.programming1.datastructures;

import java.util.Optional;

public class SdaStackImpl<T> implements SdaStack<T> {

    private Node<T> top;

    @Override
    public void push(T element) {

    }

    @Override
    public Optional<T> pop() {
        return Optional.empty();
    }

    @Override
    public Optional<T> peek() {
        return Optional.empty();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    private static class Node<T> {
        T value;
        Node<T> bottomNext;

        private Node(T value) {
            this.value = value;
        }
    }

}
