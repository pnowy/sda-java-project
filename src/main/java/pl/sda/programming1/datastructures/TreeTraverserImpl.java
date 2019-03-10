package pl.sda.programming1.datastructures;

import java.util.ArrayList;
import java.util.List;
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

    @Override
    public <T> List<T> traverseLevelOrder(SdaTree<T> tree) {
        return null;
    }

    private <T> void preOrder(SdaTree<T> tree, Consumer<T> consumer) {
        consumer.accept(tree.getValue());
        tree.getLeftChild()
                .ifPresent(leftTree -> preOrder(leftTree, consumer));
        tree.getRightChild()
                .ifPresent(rightTree -> preOrder(rightTree, consumer));
    }
}
