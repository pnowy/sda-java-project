package pl.sda.programming1;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.sda.programming1.datastructures.SdaStack;
import pl.sda.programming1.datastructures.SdaStackImpl;
import pl.sda.programming1.datastructures.TestClass;

import java.util.Optional;

public class StackTest {

    private static final Logger log = LoggerFactory.getLogger(StackTest.class);

    @Test
    public void nonGenericStack() {
        TestClass testStack = new TestClass();
        testStack.push("String");
        Optional pop = testStack.pop();
        String o = (String)pop.get();

    }

    @Test
    public void genericStackTest() {
        SdaStack<String> stack = new SdaStackImpl<>();
        Assertions.assertThat(stack.isEmpty()).isTrue();
        stack.push("SDA");
        Assertions.assertThat(stack.isEmpty()).isFalse();
        stack.push("Java");
        stack.push("Python");

        log.info("PEEK operation={}", stack.peek());

        log.info("POP operation(1)={}", stack.pop());
        log.info("POP operation(2)={}", stack.pop());
        log.info("POP operation(3)={}", stack.pop());
        log.info("POP operation(4)={}", stack.pop());
    }

    @Test
    public void overloadingTest() {
        String x = "XYZ";
        Integer y = 12;

        print(y);
    }

    private void print(String value) {
        System.out.println(value);
    }

    private void print(Integer value) {
        System.out.println(value);
    }
}
