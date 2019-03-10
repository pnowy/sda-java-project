package pl.sda.programming1.datastructures;

import java.util.*;
import java.util.function.Consumer;

public class TreeTraverserImpl implements TreeTraverser {


    @Override
    public <T> List<T> traversePreOrder(SdaTree<T> tree) {
        List<T> visited = new ArrayList<>();
//        preOrder(tree, visited::add);

//        preOrder(tree, new Consumer<T>() {
//            @Override
//            public void accept(T t) {
//                visited.add(t);
//            }
//        });

        preOrder(tree, nodeElement -> visited.add(nodeElement));
        return visited;
    }

    private <T> void preOrder(SdaTree<T> tree, Consumer<T> consumer) {
        consumer.accept(tree.getValue());
        tree.getLeftChild()
                .ifPresent(leftTree -> preOrder(leftTree, consumer));
        tree.getRightChild()
                .ifPresent(rightTree -> preOrder(rightTree, consumer));
    }

    @Override
    public <T> List<T> traverseLevelOrder(SdaTree<T> tree) {
        List<T> visited = new ArrayList<>();
        levelOrder(tree, visited::add);
        return visited;
    }

    @Override
    public int countLeaves(SdaTree<?> tree) {
        if (tree.isLeaf()) {
            return 1;
        }
        return tree.getLeftChild().map(this::countLeaves).orElse(0)
                + tree.getRightChild().map(this::countLeaves).orElse(0);
    }

//    private boolean isLeaf(SdaTree<?> tree) {
//        return !tree.getRightChild().isPresent() && !tree.getLeftChild().isPresent();
//    }

    private <T> void levelOrder(SdaTree<T> tree, Consumer<T> visitor) {
        Deque<SdaTree<T>> toVisit = new ArrayDeque<>(Collections.singletonList(tree));
        while (!toVisit.isEmpty()) {
            SdaTree<T> node = toVisit.poll();
            visitor.accept(node.getValue());
            node.getLeftChild().ifPresent(toVisit::offer);
            node.getRightChild().ifPresent(toVisit::offer);
        }
    }

}
