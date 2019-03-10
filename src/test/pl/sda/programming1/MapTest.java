package pl.sda.programming1;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.sda.programming1.datastructures.domain.*;

import java.util.*;
import java.util.function.Consumer;

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

    @Test
    public void mapTest() {
        Map<Pesel, Patient> records = new HashMap<>();
        Pesel pesel = new Pesel("85894567345");
        Pesel pesel2 = new Pesel("85894567346");
        records.put(pesel, new Patient(pesel, "Jan Kowalski"));
        records.put(pesel2, new Patient(pesel, "Jan Nowak"));

        records.entrySet().stream().forEach(new Consumer<Map.Entry<Pesel, Patient>>() {
            @Override
            public void accept(Map.Entry<Pesel, Patient> entry) {
                log.info("Entry in map. Entry key={}, entry value={}",
                        entry.getKey(), entry.getValue());
            }
        });

    }


    @Test
    public void patientRegistryTest() {
        PatientRegistry patientRegistry = new PatientRegistryImpl();

        Patient kowalski = new Patient(new Pesel("85894567345"), "Jan Kowalski");
        Patient nowak = new Patient(new Pesel("85894567346"), "Jan Nowak");

        patientRegistry.add(kowalski);
        patientRegistry.add(nowak);

        Assertions.assertThat(patientRegistry.exist(kowalski.getPesel())).isTrue();

        Assertions.assertThat(patientRegistry.size()).isEqualTo(2);

        log.info("Patient registry=\n{}", patientRegistry);
    }

    @Test
    public void mapTypes() {

        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("John Smith", "value1");
        hashMap.put("Lisa Smith", "value2");
        hashMap.put("Sandra Doe", "value3");

        log.info("HashMap={}", hashMap);

        Map<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("John Smith", "value1");
        linkedHashMap.put("Lisa Smith", "value2");
        linkedHashMap.put("Sandra Doe", "value3");

        log.info("LinkedHashMap={}", linkedHashMap);

//        Comparator<String> stringLengthComparator = new StringLengthComparator();
        Map<String, String> treeMap = new TreeMap<>(new StringLengthComparator());
        treeMap.put("Sandra", "value3");
        treeMap.put("Lisa Smith Junior", "value2");
        treeMap.put("John Smith", "value1");

        log.info("TreeMap={}", treeMap);

        Map<Integer, String> intMap = new TreeMap<>();
        intMap.put(9, "val1");
        intMap.put(17, "val2");
        intMap.put(2, "val2");

        log.info("TreeMap with integer key={}", intMap);
    }
}
