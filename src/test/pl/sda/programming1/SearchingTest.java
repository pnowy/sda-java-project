package pl.sda.programming1;

import org.junit.Test;
import pl.sda.programming1.searching.SolutionsSearching;
import pl.sda.programming1.searching.TaskSearching;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchingTest {

    private TaskSearching searching = new SolutionsSearching();

    @Test
    public void linearSearch() {
        int[] arr = {4, 6, 8, 19};
        int sevenSearchResult = searching.linearSearch(arr, 7);
        assertThat(sevenSearchResult).isNegative();
        int eightSearchResult = searching.linearSearch(arr, 8);
        assertThat(eightSearchResult).isEqualTo(2);
    }

    @Test
    public void binarySearch() {
        int[] arr = {112, 1, 5, 9, 45, 12, 55};
        Arrays.sort(arr);
        int f1 = searching.binarySearch(arr, 7);
        assertThat(f1).isNegative();
        int f2 = searching.binarySearch(arr, 5);
        assertThat(f2).isEqualTo(1);
    }
}
