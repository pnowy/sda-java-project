package pl.sda.programming1;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.sda.programming1.sorting.Sorting;
import pl.sda.programming1.sorting.SortingImpl;

public class SortingTest {

    private static final Logger log = LoggerFactory.getLogger(SortingTest.class);
    private Sorting sorting = new SortingImpl();

    @Test
    public void bubbleSortTest() {
        int[] array = {42, 7, 5, 16};
        sorting.bubbleSort(array);
        log.info("sort array = {}", array);
    }

    @Test
    public void selectionSort() {
        int[] array = {42, 7, 5, 16};
        sorting.selectionSort(array);
        log.info("sort array = {}", array);
    }

    @Test
    public void insertionSort() {
        int[] array = {42, 7, 5, 16};
        sorting.insertionSort(array);
        log.info("sort array = {}", array);
    }

    @Test
    public void quicksort() {
        int[] array = {42, 7, 5, 16};
        sorting.quickSort(array);
        log.info("sort array = {}", array);
    }
}
