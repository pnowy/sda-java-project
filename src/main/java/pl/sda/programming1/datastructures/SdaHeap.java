package pl.sda.programming1.datastructures;

public interface SdaHeap<T extends Comparable<T>> {

    /**
     * Dodanie elementu do kopca {@linkplain Comparable}
     *
     * @param element dowolna wartość typu T
     */
    void push(T element);

    /**
     * Pobiera element o najwyższej wartości z kopca
     */
    T pop();

    /**
     * Zwraca liczbę elementów w kopcu
     */
    int size();

    /**
     * Konwertuje kopiec do tablicy
     */
    T[] toArray();

}
