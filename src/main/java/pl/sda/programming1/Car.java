package pl.sda.programming1;

import org.apache.commons.lang3.RandomStringUtils;

public class Car {

    private String name;

    public Car() {
        this.name = RandomStringUtils.randomAlphabetic(10);
    }

    public String getName() {
        return name;
    }
}
