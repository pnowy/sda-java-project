package pl.sda.programming1.datastructures;

import java.util.Optional;

public interface SdaQueue<T> {

    void enqueue(T element);

    Optional<T> dequeue();

    boolean isEmpty();

    Optional<T> peek();

}
