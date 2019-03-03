package pl.sda.programming1;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;

public class SimpleTest {

    @Test
    public void shouldDoSomething() {
        CsvReader reader = new CsvReaderUtils();

        Map<String, Object> map = new HashMap<>();
        map.put("MARKA", "ALFA ROMEO");
        map.put("MODEL", "GULIETTA");
        map.put("ROK", 2012);
        map.put("KM", 300);
        map.put("CENA", BigDecimal.TEN);

        List<Car> result = reader.objects(Collections.singletonList(map));

        assert result.size() == 1;
        Car car = result.get(0);
        assert car.getPowerInKM() == 300;
        Assertions.assertThat(result).hasSize(1);
        Assertions.assertThat(car.getModelName()).isEqualToIgnoringCase("gulietta");
    }
}
