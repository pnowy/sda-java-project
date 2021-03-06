package pl.sda.programming1.datastructures;

import java.util.Optional;

public interface SdaTree<T> {

    /**
     * Tworzy nowe drzew z korzeniem o podanej wartości oraz danych poddrzewach.
     */
    static <T> SdaTree<T> of(T value, SdaTree<T> left, SdaTree<T> right) {
        return new SdaTreeImpl<>(value, left, right);
    }

    /**
     * Tworzy nowy liść drzewa (węzeł bez dzieci)
     */
    static <T> SdaTree<T> leaf(T value) {
        return new SdaTreeImpl<>(value, null, null);
    }

    T getValue();

    /**
     * Zwraca lewe poddrzewo
     */
    Optional<SdaTree<T>> getLeftChild();

    /**
     * Zwraca prawe poddrzewo
     */
    Optional<SdaTree<T>> getRightChild();

    boolean isLeaf();
}
