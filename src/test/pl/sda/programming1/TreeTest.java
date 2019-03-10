package pl.sda.programming1;

import org.junit.Test;
import pl.sda.programming1.datastructures.SdaTree;

public class TreeTest {

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

    @Test
    public void treeTest() {

    }
}
