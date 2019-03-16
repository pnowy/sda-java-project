package pl.sda.programming1;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import pl.sda.programming1.datastructures.domain.PatientType;

import static org.assertj.core.api.Assertions.assertThat;
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
    }
}
