package pl.sda.programming1.datastructures;

import java.util.List;

public interface SdaBst<T extends Comparable<T>> {

    /**
     * Wstawienie elementu do drzewa BST
     */
    void insert(T element);

    /**
     * Zwraca true jeżeli podany element znajduje się w drzewie.
     */
    boolean contains(T element);

    /**
     * Usunięcie elementu z drzewa
     */
    void delete(T element);

    /**
     * Zwraca listę zawierającą wszystkie elementy posortowane.
     */
    List<T> toList();

}
