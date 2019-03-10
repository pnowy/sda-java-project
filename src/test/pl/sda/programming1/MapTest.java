package pl.sda.programming1;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.sda.programming1.datastructures.domain.Patient;
import pl.sda.programming1.datastructures.domain.Pesel;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MapTest {

    private static final Logger log = LoggerFactory.getLogger(MapTest.class);

    @Test
    public void peselTest() {
        Map<Pesel, String> patientRegistry = new HashMap<>();
        patientRegistry.put(new Pesel("84563404323"), "Janusz");
        patientRegistry.put(new Pesel("84563404433"), "Marek");

        log.info("Map={}", patientRegistry);
    }

    @Test
    public void patientEqual() {
        Patient kowalski1 = new Patient(new Pesel("85452343843"), "Jan Kowalski");
        Patient kowalski2 = new Patient(new Pesel("74452343845"), "Jan Kowalski");

        log.info("Kowalski equals={}", kowalski1.equals(kowalski2));
    }

    @Test
    public void equalsTest() {
        Integer int1 = new Integer(5);
        Integer int2 = new Integer(5);
        log.info("Integer equals={}", int1.equals(int2));
        Pesel pesel1 = new Pesel("85894567345");
        Pesel pesel2 = new Pesel("85894567345");
        log.info("Pesel1 equals Pesel2 = {}", pesel1.equals(pesel2));
        Pesel pesel3 = pesel2;
        log.info("Pesel3 equals Pesel2 = {}", pesel3.equals(pesel2));
        pesel3 = new Pesel("85894567345");
        log.info("Pesel3 equals Pesel2 = {}", pesel3.equals(pesel2));

        Pesel pesel5 = new Pesel("85894567345");
        Pesel pesel6 = null;

        log.info("Pesel5 equals Pesel5 = {}", Objects.equals(pesel6, pesel5));
    }
}
