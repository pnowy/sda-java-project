package pl.sda.programming1;

import org.junit.Test;
import pl.sda.programming1.datastructures.TestClass;

import java.util.Optional;

public class StackTest {

    @Test
    public void nonGenericStack() {
        TestClass testStack = new TestClass();
        testStack.push("String");
        Optional pop = testStack.pop();
        String o = (String)pop.get();

    }
}
