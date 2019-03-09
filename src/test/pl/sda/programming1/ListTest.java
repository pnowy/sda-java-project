package pl.sda.programming1;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import pl.sda.programming1.datastructures.SdaLinkedList;
import pl.sda.programming1.datastructures.SdaLinkedListImpl;

public class ListTest {

    @Test
    public void testSdaLinkedList() {
        SdaLinkedList<Integer> sdaLinkedList = new SdaLinkedListImpl<>();

        Assertions.assertThat(sdaLinkedList.isEmpty()).isTrue();
        sdaLinkedList.addFirst(10);
        Assertions.assertThat(sdaLinkedList.isEmpty()).isFalse();
    }
}
