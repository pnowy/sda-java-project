package pl.sda.programming1;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.sda.programming1.datastructures.SdaLinkedList;
import pl.sda.programming1.datastructures.SdaLinkedListImpl;
import pl.sda.programming1.datastructures.domain.Pesel;

import java.util.ArrayList;

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
        sdaLinkedList.addFirst(3);
        Assertions.assertThat(sdaLinkedList.size()).isEqualTo(3);

        for (Integer element : sdaLinkedList) {
            log.info("Element in for-loop={}", element);
        }

        log.info("List info={}", sdaLinkedList);
        log.info("First element={}", sdaLinkedList.getFirst());
        log.info("Last element={}", sdaLinkedList.getLast());
        log.info("Element on index=1 is equal to={}", sdaLinkedList.get(1));
        log.info("List size={}", sdaLinkedList.size());

        sdaLinkedList.removeFirst();

        log.info("List size={}", sdaLinkedList.size());

        sdaLinkedList.removeLast();

        log.info("List size={}", sdaLinkedList.size());
        log.info("First element={}", sdaLinkedList.getFirst());

        sdaLinkedList.removeLast();
        if (!sdaLinkedList.isEmpty()) {
            log.info("First element (2)={}", sdaLinkedList.getFirst());
        }

    }

    @Test
    public void genericListTest() {
        ArrayList<String> list = new ArrayList<>();
        list.add("String");
        String s = list.get(0);

        SdaLinkedList<Integer> sdaLinkedList = new SdaLinkedListImpl<>(2, 4, 7);
        log.info("My list={}", sdaLinkedList);
    }


}
