package pl.sda.programming1.searching;

import java.util.Optional;

import static java.util.Objects.requireNonNull;

public class SolutionsSearching implements TaskSearching {

    @Override
    public int linearSearch(int[] array, int value) {
        requireNonNull(array, "The array cannot be null");

        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public <T extends Comparable> Optional<Integer> linearSearch(T[] array, T value) {
        throw new UnsupportedOperationException("TODO in home");
    }

    @Override
    public int binarySearch(int[] array, int value) {
        if (array.length == 0) {
            return -1;
        }
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
//            int mid = (low + high) / 2;
            int mid = (low + high) >>> 1;
            if (array[mid] > value) {
                high = mid - 1;
            } else if (array[mid] < value) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
