package pl.sda.programming1.datastructures;

import java.util.List;

public interface TreeTraverser {

    <T> List<T> traversePreOrder(SdaTree<T> tree);

    <T> List<T> traverseLevelOrder(SdaTree<T> tree);

    int countLeaves(SdaTree<?> tree);

}
