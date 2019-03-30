package pl.sda.programming1;

import org.junit.Test;
import pl.sda.programming1.searching.SolutionsSearching;
import pl.sda.programming1.searching.TaskSearching;

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
}
