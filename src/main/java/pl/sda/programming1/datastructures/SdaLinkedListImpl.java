package pl.sda.programming1.datastructures;

import java.util.NoSuchElementException;

public class SdaLinkedListImpl<T> implements SdaLinkedList<T> {

    private Node<T> head;

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public T getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("The list is empty! Nothing to get!");
        }
        return head.element;
    }

    @Override
    public T getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("The list is empty! Nothing to get!");
        }
        return nodeLast().element;
    }

    @Override
    public T get(int index) {
        return null;
    }



    @Override
    public void addFirst(T element) {
        head = new Node<>(element, head);
    }

    @Override
    public void addLast(T element) {
        if (isEmpty()) {
            addFirst(element);
        } else {
            nodeLast().next = new Node<>(element, null);
        }
    }

    private Node<T> nodeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("The list is empty! You cannot do that!");
        }
        Node<T> last = head;
        while (last.next != null) {
            last = last.next;
        }
        return last;
    }

    @Override
    public void removeFirst() {

    }

    @Override
    public void removeLast() {

    }

    private static class Node<T> {
        private T element;
        private Node<T> next;

        private Node(T element, Node<T> next) {
            this.element = element;
            this.next = next;
        }
    }

}
