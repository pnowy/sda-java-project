package pl.sda.programming1.datastructures;

import java.util.Objects;
import java.util.Optional;

public class SdaTreeImpl<T> implements SdaTree<T> {

    private final T value;
    private final SdaTree<T> left;
    private final SdaTree<T> right;

    public SdaTreeImpl(T value, SdaTree<T> left, SdaTree<T> right) {
        this.value = Objects.requireNonNull(value, "Value cannot be null!");
        this.left = left;
        this.right = right;
    }

    @Override
    public T getValue() {
        return value;
    }

    @Override
    public Optional<SdaTree<T>> getLeftChild() {
        return Optional.ofNullable(left);
    }

    @Override
    public Optional<SdaTree<T>> getRightChild() {
        return Optional.ofNullable(right);
    }

    @Override
    public boolean isLeaf() {
        return !getRightChild().isPresent() && !getLeftChild().isPresent();
    }

}
