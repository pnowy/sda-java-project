package pl.sda.programming1.sorting;

public interface Sorting {

    /**
     * Bubble sort (sortowanie bąbelkowe)
     */
    void bubbleSort(int[] array);

    /**
     * Selection sort (sortowanie przez wybieranie)
     */
    void selectionSort(int[] array);

    /**
     * Insertion sort (sortowanie przez wstawianie)
     */
    void insertionSort(int[] array);
}
