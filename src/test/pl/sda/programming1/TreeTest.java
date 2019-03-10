package pl.sda.programming1;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.sda.programming1.datastructures.SdaTree;
import pl.sda.programming1.datastructures.TreeTraverser;
import pl.sda.programming1.datastructures.TreeTraverserImpl;

import java.util.List;

public class TreeTest {

    private static final Logger log = LoggerFactory.getLogger(TreeTest.class);

    private SdaTree<String> exampleTree =
            SdaTree.of("F",
                    SdaTree.of("B",
                            SdaTree.leaf("A"),
                            SdaTree.of("D",
                                    SdaTree.leaf("C"),
                                    SdaTree.leaf("E"))),
                    SdaTree.of("G",
                            null, SdaTree.of("I",
                                    SdaTree.leaf("H"),
                                    null))
            );

    TreeTraverser treeTraverser = new TreeTraverserImpl();

    @Test
    public void treeTest() {
        List<String> order = treeTraverser.traversePreOrder(exampleTree);
        log.info("Tree pre order = {}", order);
    }
}
