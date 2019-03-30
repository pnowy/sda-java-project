package pl.sda.programming1.searching;

import java.util.Optional;

public interface TaskSearching {

    /**
     * Wyszukuje element w tablicy
     *
     * Zwraca -1 jeżeli element nie znajduje się w tablicy
     */
    int linearSearch(int[] array, int value);

    // TODO in home
    <T extends Comparable> Optional<Integer> linearSearch(T[] array, T value);

    /**
     * Wyszukuje element w tablicy (tablica musi być posortowana).
     *
     * Zwraca -1 jeżeli element nie znajduje się w tablicy
     */
    int binarySearch(int[] array, int value);

}
