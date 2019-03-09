package pl.sda.programming1.datastructures;

public interface SdaLinkedList<T> {

    /**
     * Czy lista jest pusta
     */
    boolean isEmpty();

    /**
     * Liczba elementów w liście
     */
    int size();

    T getFirst();

    T getLast();

    T get(int index);

    void addFirst(T element);

    void addLast(T element);

    void removeFirst();

    void removeLast();
}
