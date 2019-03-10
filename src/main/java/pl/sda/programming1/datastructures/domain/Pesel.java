package pl.sda.programming1.datastructures.domain;

import java.util.Comparator;
import java.util.Objects;

public class Pesel implements Comparable<Pesel> {

    private final String value;
//
//    public Pesel(String value, Comparator<Pesel> comparator) {
//        this(value);
//        this.comparator = comparator;
//    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pesel pesel = (Pesel) o;
        return value.equals(pesel.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Pesel{" +
                "value='" + value + '\'' +
                '}';
    }

    @Override
    public int compareTo(Pesel o) {
        return 0;
    }
}
