package pl.sda.programming1;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.sda.programming1.datastructures.SdaQueue;
import pl.sda.programming1.datastructures.SdaQueueImpl;

public class QueueTest {
    private static final Logger log = LoggerFactory.getLogger(QueueTest.class);
    @Test
    public void ququeTest() {
        SdaQueue<String> queue = new SdaQueueImpl<>();
        Assertions.assertThat(queue.isEmpty()).isTrue();

        queue.enqueue("X");
        queue.enqueue("Y");
        queue.enqueue("Z");

        log.info("Queue={}", queue.peek());
        log.info("Queue={}", queue.dequeue());
        log.info("Queue={}", queue.dequeue());
        log.info("Queue={}", queue.dequeue());
        log.info("Queue={}", queue.dequeue());

    }
}
