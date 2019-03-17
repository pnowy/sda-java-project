package pl.sda.programming1.sorting;

public class SortingImpl implements Sorting {

    @Override
    public void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j+1]){
                    swap(j, j + 1, array);
                }
            }
        }
    }

    @Override
    public void selectionSort(int[] array) {
        int sortedIndex = 0;
        for (int j = 0; j < array.length; j++) {
            int minIndex = sortedIndex;
            for (int i = sortedIndex + 1; i < array.length; i++) {
                if (array[i] < array[minIndex]) {
                    minIndex = i;
                }
            }
            swap(sortedIndex, minIndex, array);
            sortedIndex++;
        }
    }

    @Override
    public void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int movedValue = array[i];
            int destination = i;
            for (int j = i - 1; j >= 0; j--) {
                if (movedValue < array[j]) {
                    moveRight(array, j);
                    destination = j;
                } else {
                    break;
                }
            }
            array[destination] = movedValue;
        }
    }

    private void moveRight(int[] array, int j) {
        array[j+1] = array[j];
    }

    private void swap(int j, int i, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
