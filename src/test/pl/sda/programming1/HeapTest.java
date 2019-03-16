package pl.sda.programming1;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.sda.programming1.datastructures.FixedSizeSdaHeap;
import pl.sda.programming1.datastructures.SdaHeap;
import pl.sda.programming1.datastructures.domain.Username;

import java.util.Arrays;

public class HeapTest {

    private static final Logger log = LoggerFactory.getLogger(HeapTest.class);

    @Test
    public void createHeap() {
        SdaHeap<Integer> heap =
                new FixedSizeSdaHeap<>(new Integer[]{100, 45, 40, 19}, 10);

        log.info("heap as array = {}", Arrays.toString(heap.toArray()));

        heap.push(120);
        heap.push(46);

        log.info("heap as array = {}", Arrays.toString(heap.toArray()));
//        Assertions.assertThat(heap.pop()).isNotNull();
        log.info("get heap element = {}", heap.pop());
        log.info("heap as array = {}", Arrays.toString(heap.toArray()));
    }

    @Test
    public void usernameHeapTest() {
        SdaHeap<Username> heap =
                new FixedSizeSdaHeap<>(new Username[]{
                        new Username("zbigniew"), new Username("Zosia"),
                        new Username("abc"), new Username("janusz")
                }, 10);

        log.info("heap as array = {}", Arrays.toString(heap.toArray()));
        heap.push(new Username("aaa"));
        log.info("heap as array = {}", Arrays.toString(heap.toArray()));
    }

}
