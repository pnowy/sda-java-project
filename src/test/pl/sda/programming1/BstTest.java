package pl.sda.programming1;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.sda.programming1.datastructures.SdaBst;
import pl.sda.programming1.datastructures.SdaBstImpl;

public class BstTest {

    private static final Logger log = LoggerFactory.getLogger(BstTest.class);

    @Test
    public void insertTest() {
        SdaBst<Integer> bst = new SdaBstImpl<>(
                new Integer[]{}
        );

        bst.insert(5);
        bst.insert(6);
        bst.insert(7);

        Assertions.assertThat(bst.contains(5)).isTrue();
        Assertions.assertThat(bst.contains(8)).isFalse();

        bst.insert(100);
        bst.insert(199);
        bst.insert(55);

        log.info("bst tree as list = {}", bst.toList());
        bst.delete(55);
        log.info("bst tree as list = {}", bst.toList());
    }
}
