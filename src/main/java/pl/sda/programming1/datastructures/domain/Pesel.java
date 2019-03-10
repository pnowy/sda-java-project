package pl.sda.programming1.datastructures.domain;

public class Pesel {

    private final String value;

    public Pesel(String value) {
        if (value == null) {
            throw new NullPointerException("The pesel cannot be null!");
        }
        if (value.length() != 11) {
            throw new IllegalArgumentException("Invalid PESEL!");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }



}
