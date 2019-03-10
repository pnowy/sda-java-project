package pl.sda.programming1;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.sda.programming1.datastructures.domain.Pesel;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetTest {

    private static final Logger log = LoggerFactory.getLogger(SetTest.class);

    @Test
    public void setTest() {
        Set<String> set = new HashSet<>();

        set.add("Kowalski");
        set.add("Nowak");
        set.add("Kowalski");

        log.info("Set={}", set);

        Set<Pesel> pesels = new LinkedHashSet<>();
        pesels.add(new Pesel("88776654321"));
        pesels.add(new Pesel("88776654324"));
        pesels.add(new Pesel("88776654321"));

        log.info("Size: {}, Pesels={}", pesels.size(), pesels);
    }
}
