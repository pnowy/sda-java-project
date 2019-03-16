package pl.sda.programming1;

import com.google.common.collect.Lists;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import pl.sda.programming1.datastructures.domain.PatientType;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;
import static pl.sda.programming1.datastructures.domain.PatientType.*;

public class StreamTest {

    private Streams streams = new StreamsImpl();

    @Test
    public void indexOfTest() {
        assertThat(streams.indexOf("ala ma kota", 'k')).hasValue(7);
        assertThat(streams.indexOf("ala ma kota", 'd').isPresent()).isFalse();
        assertThat(streams.indexOf("ala ma kota", 'd')).isNotPresent();
    }

    @Test
    public void maxTest() {
        assertThat(streams.getMax(new int[]{4, 7, 199, 9})).hasValue(199);
        assertThat(streams.getMax(new int[]{})).isEmpty();
        PatientType patientType = GOLD;
        patientType.doSomething();
        assertThat(patientType).isNotEqualTo(DEAD);

        assertThat(streams.getMax(Lists.newArrayList(34, 5, 111))).hasValue(111);
    }

    @Test
    public void avgTest() {

    }

    @Test
    public void streamExamples() {
        Function<String, Integer> convertToInteger = stringValue -> {
            return Integer.valueOf(stringValue);
        };
        Consumer<Integer> printlnConsumerContract = System.out::println;
        Function<String, Integer> transformStringToInteger = Integer::valueOf;
        Lists.newArrayList("1", "2", "3").stream()
                .map(transformStringToInteger)
                .map(intValue -> {
                    return intValue * 2;
                })
                .filter(integer -> integer > 1)
                .forEach(printlnConsumerContract);
    }
}
