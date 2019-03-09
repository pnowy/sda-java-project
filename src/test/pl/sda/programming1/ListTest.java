package pl.sda.programming1;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.sda.programming1.datastructures.SdaLinkedList;
import pl.sda.programming1.datastructures.SdaLinkedListImpl;

public class ListTest {

    private static final Logger log = LoggerFactory.getLogger(ListTest.class);

    @Test
    public void testSdaLinkedList() {
        SdaLinkedList<Integer> sdaLinkedList = new SdaLinkedListImpl<>();

        Assertions.assertThat(sdaLinkedList.isEmpty()).isTrue();
        sdaLinkedList.addFirst(10);
        Assertions.assertThat(sdaLinkedList.isEmpty()).isFalse();
        sdaLinkedList.addLast(99);

        Assertions.assertThat(sdaLinkedList.getFirst()).isEqualTo(10);
        log.info("First element={}", sdaLinkedList.getFirst());
        log.info("Last element={}", sdaLinkedList.getLast());
    }
}
