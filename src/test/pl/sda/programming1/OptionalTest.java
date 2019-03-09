package pl.sda.programming1;

import org.apache.commons.lang3.RandomUtils;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;
import java.util.function.Function;

public class OptionalTest {

    private static final Logger log = LoggerFactory.getLogger(OptionalTest.class);

    @Test
    public void testOptional() {
        Optional<String> optionalWithString = exampleText();
        if (optionalWithString.isPresent()) {
            String string = optionalWithString.get();
            log.info("Non null. Value={}", string.toLowerCase());
        } else {
            log.info("Nullable. Do nothing.");
        }
        String s = optionalWithString
                .map(String::toLowerCase)
                .orElse("NOTHING");
        log.info("Optional result={}", s);

        Assertions.assertThat(12);
    }

    private Optional<String> exampleText() {
        String myText = "SDA";
        boolean randomBoolean = RandomUtils.nextBoolean();
        if (randomBoolean) {
            return Optional.of(myText);
        } else {
            return Optional.empty();
        }
    }

}
