package pl.sda.programming1;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.sda.programming1.datastructures.SetUtils;
import pl.sda.programming1.datastructures.SetUtilsImpl;
import pl.sda.programming1.datastructures.domain.Pesel;

import java.util.*;

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

    SetUtils setUtils = new SetUtilsImpl();

    @Test
    public void duplicates() {
        List<String> list = Arrays.asList("A", "B", "C", "B", "F", "C");
        log.info("Duplicates in list={}", setUtils.findDuplicates(list));
    }

    @Test
    public void commonValues() {
        List<String> list1 = new ArrayList<>(Arrays.asList("A", "B", "C", "B", "F", "C"));
        List<String> list2 = new ArrayList<>(Arrays.asList("A", "X", "Y", "Z", "B", "B"));
        System.out.println(new HashSet<>(list2));
//        list1.retainAll(list2);
//        list2.retainAll(list1);
//        System.out.println(list2);
//        log.info("Common in list={}", setUtils.findCommonValues(list1, list2));
    }
}
