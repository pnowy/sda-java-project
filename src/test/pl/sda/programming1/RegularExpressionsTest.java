package pl.sda.programming1;

import org.junit.Test;

public class RegularExpressionsTest {

    @Test
    public void regularExpressionTest() {
        boolean matches = "aba".matches("a*");
        System.out.println(matches);
    }
}
