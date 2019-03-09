package pl.sda.programming1.datastructures;

public class SdaLinkedListImpl<T> implements SdaLinkedList<T> {

    private Node<T> head;

    @Override
    public boolean isEmpty() {
        return head != null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public T getFirst() {
        return null;
    }

    @Override
    public T getLast() {
        return null;
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
