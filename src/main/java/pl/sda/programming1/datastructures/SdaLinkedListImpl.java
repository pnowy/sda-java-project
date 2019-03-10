package pl.sda.programming1.datastructures;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SdaLinkedListImpl<T> implements SdaLinkedList<T> {

    private Node<T> head;

    public SdaLinkedListImpl() {}

    public SdaLinkedListImpl(T ... elements) {
        Arrays.asList(elements).forEach(element -> {
            addFirst(element);
        });
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int size() {
        int size = 0;
        Node<T> node = head;
        while (node != null) {
            node = node.next;
            size++;
        }
        return size;
    }

    @Override
    public T getFirst() {
        checkListIsNotEmpty();
        return head.element;
    }

    @Override
    public T getLast() {
        checkListIsNotEmpty();
        return nodeLast().element;
    }

    @Override
    public T get(int index) {
        return nodeAt(index).element;
    }

    private Node<T> nodeAt(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Index cannot be negative!");
        }
        checkListIsNotEmpty();
        Node<T> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
            if (node == null) {
                throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
            }
        }
        return node;
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
        checkListIsNotEmpty();
        Node<T> last = head;
        while (last.next != null) {
            last = last.next;
        }
        return last;
    }

    @Override
    public void removeFirst() {
        checkListIsNotEmpty();
        head = head.next;
    }

    @Override
    public void removeLast() {
        checkListIsNotEmpty();

        // przypydek gdy lista ma jeden element
        if (head.next == null) {
            head = null;
            return;
        }

        Node<T> prev = head;
        Node<T> last = head.next;
        while (last.next != null) {
            prev = last;
            last = last.next;
        }
        prev.next = null;
    }

    private void checkListIsNotEmpty() {
        if (isEmpty()) {
            throw new NoSuchElementException("The list is empty!");
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (node == null) {
                    throw new NoSuchElementException("There is no element in the list!");
                }
                T element = node.element;
                node = node.next;
                return element;
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        for (T element : this) {
            sb.append(element).append(" | ");
        }
        return sb.append(" ]").toString();
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
