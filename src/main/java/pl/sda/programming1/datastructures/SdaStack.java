package pl.sda.programming1.datastructures;

import java.util.Optional;

public interface SdaStack<T> {

    void push(T element);

    Optional<T> pop();

    Optional<T> peek();

    boolean isEmpty();
}
